package com.example.obj.region;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegionsDTO {

    @SerializedName("areas")
    private List<AreasBeanX> areas;

    public List<AreasBeanX> getAreas() {
        return areas;
    }

    public void setAreas(List<AreasBeanX> areas) {
        this.areas = areas;
    }

    public class AreasBeanX {
        @SerializedName("areas")
        private List<AreasBean> areas;

        public List<AreasBean> getAreas() {
            return areas;
        }

        public void setAreas(List<AreasBean> areas) {
            this.areas = areas;
        }

        public class AreasBean {
            @SerializedName("parent_id")
            private String parentId;
            @SerializedName("id")
            private String id;
            @SerializedName("name")
            private String name;
            @SerializedName("areas")
            private List<?> areas;

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<?> getAreas() {
                return areas;
            }

            public void setAreas(List<?> areas) {
                this.areas = areas;
            }
        }
    }
}
