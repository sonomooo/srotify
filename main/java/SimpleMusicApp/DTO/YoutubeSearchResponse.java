package SimpleMusicApp.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class YoutubeSearchResponse {

    private Items item;

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public static class Items{
        private List<Item> itemList;

        public List<Item> getItemList() {
            return itemList;
        }

        public void setItemList(List<Item> itemList) {
            this.itemList = itemList;
        }
    }

    public static class Item{

        private String title;
        private String videoId;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }
    }

}
