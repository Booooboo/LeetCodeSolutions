import java.util.List;

/**
 * Created by sunhongbo on 16/7/6.
 */
public class GsonFormatTest {


    private String kind;

    private String etag;

    private String nextPageToken;

    /**
     * totalResults : 1000000
     * resultsPerPage : 2
     */

    private PageInfoBean pageInfo;

    private List<ItemsBean> items;


    public static class PageInfoBean {
        private long totalResults;

        private int resultsPerPage;
    }

    public static class ItemsBean {
        private String kind;

        private String etag;

        private IdBean id;

        private SnippetBean snippet;


        public static class IdBean {
            private String kind;

            private String videoId;

        }

        public static class SnippetBean {
            private String publishedAt;

            private String channelId;

            private String title;

            private String description;

            private ThumbnailsBean thumbnails;

            private String channelTitle;

            private String liveBroadcastContent;


            public static class ThumbnailsBean {

                private MediumBean medium;

                private HighBean high;

                public static class MediumBean {
                    private String url;
                }

                public static class HighBean {
                    private String url;
                }
            }
        }
    }
}
