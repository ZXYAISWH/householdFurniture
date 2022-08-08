package com.duing.showFurniture.dnamic;

import org.apache.ibatis.annotations.Param;

public class FurnitureDnamic {

    public String provideSql(@Param("value") String value) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("select * from f_furniture order by");
        if ("新品上市".equals(value)) {
            buffer.append(" add_time desc");
        } else if ("销量从低到高".equals(value)) {
            buffer.append(" clicks asc");
        } else if ("销量从高到低".equals(value)) {
            buffer.append(" clicks desc");
        } else {
            buffer.delete(0, buffer.length());
            if ("价格从低到高".equals(value)) {
                buffer.append("SELECT * FROM `f_furniture` f,`f_furniture_inventory` i WHERE f.`furniture_id` = i.`furniture_id` ORDER BY `furniture_price` ");
            } else {
                buffer.append("SELECT * FROM `f_furniture` f,`f_furniture_inventory` i WHERE f.`furniture_id` = i.`furniture_id` ORDER BY `furniture_price` desc");
            }
        }
        return buffer.toString();
    }

    public String dnamicToProList(@Param("value") String value) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM `f_furniture` f ,`f_furniture_classify` c WHERE f.`classify_id` = c.`classify_id` AND c.`classify_name` = '干花花艺' ORDER BY ");
        if ("新品上市".equals(value)) {
            buffer.append("f.`add_time` desc");
        } else if ("销量从低到高".equals(value)) {
            buffer.append("f.`clicks` asc");
        } else if ("销量从高到低".equals(value)) {
            buffer.append("f.`clicks` desc");
        } else {
            buffer.delete(0, buffer.length());
            if ("价格从低到高".equals(value)) {
                buffer.append("\n" +
                        "SELECT * FROM `f_furniture` f ,`f_furniture_classify` c,`f_furniture_inventory` i WHERE f.`classify_id` = c.`classify_id` AND f.`furniture_id` = i.`furniture_id` AND c.`classify_name` = '干花花艺' ORDER BY i.`furniture_price`");
            } else {
                buffer.append("\n" +
                        "SELECT * FROM `f_furniture` f ,`f_furniture_classify` c,`f_furniture_inventory` i WHERE f.`classify_id` = c.`classify_id` AND f.`furniture_id` = i.`furniture_id` AND c.`classify_name` = '干花花艺' ORDER BY i.`furniture_price` desc");
            }
        }
        return buffer.toString();
    }

    public String dnamicToVaseProList(@Param("value") String value) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM `f_furniture` f ,`f_furniture_classify` c WHERE f.`classify_id` = c.`classify_id` AND c.`classify_name` = '花瓶花器' ORDER BY ");
        if ("新品上市".equals(value)) {
            buffer.append("f.`add_time` desc");
        } else if ("销量从低到高".equals(value)) {
            buffer.append("f.`clicks` asc");
        } else if ("销量从高到低".equals(value)) {
            buffer.append("f.`clicks` desc");
        } else {
            buffer.delete(0, buffer.length());
            if ("价格从低到高".equals(value)) {
                buffer.append("\n" +
                        "SELECT * FROM `f_furniture` f ,`f_furniture_classify` c,`f_furniture_inventory` i WHERE f.`classify_id` = c.`classify_id` AND f.`furniture_id` = i.`furniture_id` AND c.`classify_name` = '花瓶花器' ORDER BY i.`furniture_price`");
            } else {
                buffer.append("\n" +
                        "SELECT * FROM `f_furniture` f ,`f_furniture_classify` c,`f_furniture_inventory` i WHERE f.`classify_id` = c.`classify_id` AND f.`furniture_id` = i.`furniture_id` AND c.`classify_name` = '花瓶花器' ORDER BY i.`furniture_price` desc");
            }
        }
        return buffer.toString();
    }

    public String dnamicToZbProList(@Param("value") String value) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM `f_furniture` f ,`f_furniture_classify` c WHERE f.`classify_id` = c.`classify_id` AND c.`classify_name` = '桌布罩件' ORDER BY ");
        if ("新品上市".equals(value)) {
            buffer.append("f.`add_time` desc");
        } else if ("销量从低到高".equals(value)) {
            buffer.append("f.`clicks` asc");
        } else if ("销量从高到低".equals(value)) {
            buffer.append("f.`clicks` desc");
        } else {
            buffer.delete(0, buffer.length());
            if ("价格从低到高".equals(value)) {
                buffer.append("\n" +
                        "SELECT * FROM `f_furniture` f ,`f_furniture_classify` c,`f_furniture_inventory` i WHERE f.`classify_id` = c.`classify_id` AND f.`furniture_id` = i.`furniture_id` AND c.`classify_name` = '桌布罩件' ORDER BY i.`furniture_price`");
            } else {
                buffer.append("\n" +
                        "SELECT * FROM `f_furniture` f ,`f_furniture_classify` c,`f_furniture_inventory` i WHERE f.`classify_id` = c.`classify_id` AND f.`furniture_id` = i.`furniture_id` AND c.`classify_name` = '桌布罩件' ORDER BY i.`furniture_price` desc");
            }
        }
        return buffer.toString();
    }

    public String dnamicToBzProList(@Param("value") String value) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM `f_furniture` f ,`f_furniture_classify` c WHERE f.`classify_id` = c.`classify_id` AND c.`classify_name` = '抱枕靠垫' ORDER BY ");
        if ("新品上市".equals(value)) {
            buffer.append("f.`add_time` desc");
        } else if ("销量从低到高".equals(value)) {
            buffer.append("f.`clicks` asc");
        } else if ("销量从高到低".equals(value)) {
            buffer.append("f.`clicks` desc");
        } else {
            buffer.delete(0, buffer.length());
            if ("价格从低到高".equals(value)) {
                buffer.append("\n" +
                        "SELECT * FROM `f_furniture` f ,`f_furniture_classify` c,`f_furniture_inventory` i WHERE f.`classify_id` = c.`classify_id` AND f.`furniture_id` = i.`furniture_id` AND c.`classify_name` = '抱枕靠垫' ORDER BY i.`furniture_price`");
            } else {
                buffer.append("\n" +
                        "SELECT * FROM `f_furniture` f ,`f_furniture_classify` c,`f_furniture_inventory` i WHERE f.`classify_id` = c.`classify_id` AND f.`furniture_id` = i.`furniture_id` AND c.`classify_name` = '抱枕靠垫' ORDER BY i.`furniture_price` desc");
            }
        }
        return buffer.toString();
    }
}

