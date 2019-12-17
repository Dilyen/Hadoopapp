package io.turntabl.Hadoopapp.controller;


import io.turntabl.Hadoopapp.model.TweetsTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component("DataService")
public class DataService {

    @Autowired
    DataSource dataSource;

    Logger logger = LoggerFactory.getLogger(DataService.class);

    List<TweetsTO> tweets = new ArrayList<>();

    public List<TweetsTO> getAllTweets() {

        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement query = connection.prepareStatement("select * from tweets");
            query.clearParameters();
            ResultSet rs = query.executeQuery();
            while(rs.next()){ ;
                tweets.add(rowMapper(rs));
            }

        }catch (SQLException sqle){
            System.out.println("Connection err: " + sqle);
        }

        return tweets;
    }

    private TweetsTO rowMapper(ResultSet rs) throws SQLException {
        TweetsTO tweet = new TweetsTO(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("screenName"),
                rs.getString("location"),
                rs.getInt("reTweetCount"),
                rs.getInt("followersCount")
        );
        return tweet;
    }


}
