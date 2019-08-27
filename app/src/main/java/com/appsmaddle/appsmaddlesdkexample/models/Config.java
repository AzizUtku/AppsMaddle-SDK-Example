package com.appsmaddle.appsmaddlesdkexample.models;

public class Config {
    public String version;
    public String url;
    public Multilingual multilingual;

    public class Multilingual {
        public String locale;
        public boolean test;
        public boolean show_message;
        public String message_title;
        public String message_desc;

        @Override
        public String toString() {
            return "{" +
                    "locale='" + locale + '\'' +
                    ", test=" + test +
                    ", show_message=" + show_message +
                    ", message_title='" + message_title + '\'' +
                    ", message_desc='" + message_desc + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "{" +
                "version='" + version + '\'' +
                ", url='" + url + '\'' +
                ", multilingual=" + multilingual +
                '}';
    }
}
