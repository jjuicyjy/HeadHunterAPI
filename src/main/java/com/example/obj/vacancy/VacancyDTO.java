package com.example.obj.vacancy;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VacancyDTO {

    @SerializedName("page")
    private int page;
    @SerializedName("per_page")
    private int perPage;
    @SerializedName("pages")
    private int pages;
    @SerializedName("arguments")
    private Object arguments;
    @SerializedName("found")
    private int found;
    @SerializedName("items")
    private List<ItemsBean> items;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Object getArguments() {
        return arguments;
    }

    public void setArguments(Object arguments) {
        this.arguments = arguments;
    }

    public int getFound() {
        return found;
    }

    public void setFound(int found) {
        this.found = found;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public class ItemsBean {
        @SerializedName("employer")
        private EmployerBean employer;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("sort_point_distance")
        private Object sortPointDistance;
        @SerializedName("response_letter_required")
        private boolean responseLetterRequired;
        @SerializedName("type")
        private TypeBean type;
        @SerializedName("premium")
        private boolean premium;
        @SerializedName("area")
        private AreaBean area;
        @SerializedName("apply_alternate_url")
        private String applyAlternateUrl;
        @SerializedName("alternate_url")
        private String alternateUrl;
        @SerializedName("archived")
        private boolean archived;
        @SerializedName("name")
        private String name;
        @SerializedName("contacts")
        private Object contacts;
        @SerializedName("snippet")
        private SnippetBean snippet;
        @SerializedName("response_url")
        private Object responseUrl;
        @SerializedName("has_test")
        private boolean hasTest;
        @SerializedName("salary")
        private Salary salary;
        @SerializedName("id")
        private String id;
        @SerializedName("published_at")
        private String publishedAt;
        @SerializedName("department")
        private Object department;
        @SerializedName("address")
        private AddressBean address;
        @SerializedName("url")
        private String url;
        @SerializedName("relations")
        private List<?> relations;

        public EmployerBean getEmployer() {
            return employer;
        }

        public void setEmployer(EmployerBean employer) {
            this.employer = employer;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Object getSortPointDistance() {
            return sortPointDistance;
        }

        public void setSortPointDistance(Object sortPointDistance) {
            this.sortPointDistance = sortPointDistance;
        }

        public boolean isResponseLetterRequired() {
            return responseLetterRequired;
        }

        public void setResponseLetterRequired(boolean responseLetterRequired) {
            this.responseLetterRequired = responseLetterRequired;
        }

        public TypeBean getType() {
            return type;
        }

        public void setType(TypeBean type) {
            this.type = type;
        }

        public boolean isPremium() {
            return premium;
        }

        public void setPremium(boolean premium) {
            this.premium = premium;
        }

        public AreaBean getArea() {
            return area;
        }

        public void setArea(AreaBean area) {
            this.area = area;
        }

        public String getApplyAlternateUrl() {
            return applyAlternateUrl;
        }

        public void setApplyAlternateUrl(String applyAlternateUrl) {
            this.applyAlternateUrl = applyAlternateUrl;
        }

        public String getAlternateUrl() {
            return alternateUrl;
        }

        public void setAlternateUrl(String alternateUrl) {
            this.alternateUrl = alternateUrl;
        }

        public boolean isArchived() {
            return archived;
        }

        public void setArchived(boolean archived) {
            this.archived = archived;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getContacts() {
            return contacts;
        }

        public void setContacts(Object contacts) {
            this.contacts = contacts;
        }

        public SnippetBean getSnippet() {
            return snippet;
        }

        public void setSnippet(SnippetBean snippet) {
            this.snippet = snippet;
        }

        public Object getResponseUrl() {
            return responseUrl;
        }

        public void setResponseUrl(Object responseUrl) {
            this.responseUrl = responseUrl;
        }

        public boolean isHasTest() {
            return hasTest;
        }

        public void setHasTest(boolean hasTest) {
            this.hasTest = hasTest;
        }

        public Salary getSalary() {
            return salary;
        }

        public void setSalary(Salary salary) {
            this.salary = salary;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public Object getDepartment() {
            return department;
        }

        public void setDepartment(Object department) {
            this.department = department;
        }

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
            this.address = address;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<?> getRelations() {
            return relations;
        }

        @Override
        public String toString() {
            return "ItemsBean{" +
                    "employer=" + employer +
                    ", createdAt='" + createdAt + '\'' +
                    ", sortPointDistance=" + sortPointDistance +
                    ", responseLetterRequired=" + responseLetterRequired +
                    ", type=" + type +
                    ", premium=" + premium +
                    ", area=" + area +
                    ", applyAlternateUrl='" + applyAlternateUrl + '\'' +
                    ", alternateUrl='" + alternateUrl + '\'' +
                    ", archived=" + archived +
                    ", name='" + name + '\'' +
                    ", contacts=" + contacts +
                    ", snippet=" + snippet +
                    ", responseUrl=" + responseUrl +
                    ", hasTest=" + hasTest +
                    ", salary=" + salary +
                    ", id='" + id + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", department=" + department +
                    ", address=" + address +
                    ", url='" + url + '\'' +
                    ", relations=" + relations +
                    '}';
        }

        public void setRelations(List<?> relations) {
            this.relations = relations;
        }

        public class Salary{
            private Integer to,from;
            private String currency;
            private boolean gross;

            public Integer getTo() { return to; }
            public void setTo(Integer to) { this.to = to; }
            public Integer getFrom() { return from; }
            public void setFrom(Integer from) { this.from = from; }
            public String getCurrency() { return currency; }
            public void setCurrency(String currency) { this.currency = currency; }
            public boolean isGross() { return gross; }
            public void setGross(boolean gross) { this.gross = gross; }

            @Override
            public String toString() {
                return "Salary{" +
                        "to=" + to +
                        ", from=" + from +
                        ", currency='" + currency + '\'' +
                        ", gross=" + gross +
                        '}';
            }
        }

        public class EmployerBean {
            @Override
            public String toString() {
                return "EmployerBean{" +
                        "name='" + name + '\'' +
                        ", trusted=" + trusted +
                        ", vacanciesUrl='" + vacanciesUrl + '\'' +
                        ", id='" + id + '\'' +
                        ", alternateUrl='" + alternateUrl + '\'' +
                        ", url='" + url + '\'' +
                        ", logoUrls=" + logoUrls +
                        '}';
            }

            @SerializedName("name")
            private String name;
            @SerializedName("trusted")
            private boolean trusted;
            @SerializedName("vacancies_url")
            private String vacanciesUrl;
            @SerializedName("id")
            private String id;
            @SerializedName("alternate_url")
            private String alternateUrl;
            @SerializedName("url")
            private String url;
            @SerializedName("logo_urls")
            private LogoUrlsBean logoUrls;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isTrusted() {
                return trusted;
            }

            public void setTrusted(boolean trusted) {
                this.trusted = trusted;
            }

            public String getVacanciesUrl() {
                return vacanciesUrl;
            }

            public void setVacanciesUrl(String vacanciesUrl) {
                this.vacanciesUrl = vacanciesUrl;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAlternateUrl() {
                return alternateUrl;
            }

            public void setAlternateUrl(String alternateUrl) {
                this.alternateUrl = alternateUrl;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public LogoUrlsBean getLogoUrls() {
                return logoUrls;
            }

            public void setLogoUrls(LogoUrlsBean logoUrls) {
                this.logoUrls = logoUrls;
            }

            public class LogoUrlsBean {

                @SerializedName("240")
                private String $240;
                @SerializedName("original")
                private String original;
                @SerializedName("90")
                private String $90;

                public String get$240() {
                    return $240;
                }

                public void set$240(String $240) {
                    this.$240 = $240;
                }

                public String getOriginal() {
                    return original;
                }

                public void setOriginal(String original) {
                    this.original = original;
                }

                public String get$90() {
                    return $90;
                }

                public void set$90(String $90) {
                    this.$90 = $90;
                }

                @Override
                public String toString() {
                    return "LogoUrlsBean{" +
                            "$240='" + $240 + '\'' +
                            ", original='" + original + '\'' +
                            ", $90='" + $90 + '\'' +
                            '}';
                }
            }
        }

        public class TypeBean {
            @Override
            public String toString() {
                return "TypeBean{" +
                        "name='" + name + '\'' +
                        ", id='" + id + '\'' +
                        '}';
            }

            @SerializedName("name")
            private String name;
            @SerializedName("id")
            private String id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public class AreaBean {
            @Override
            public String toString() {
                return "AreaBean{" +
                        "name='" + name + '\'' +
                        ", id='" + id + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            @SerializedName("name")
            private String name;
            @SerializedName("id")
            private String id;
            @SerializedName("url")
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public class SnippetBean {
            @Override
            public String toString() {
                return "SnippetBean{" +
                        "responsibility='" + responsibility + '\'' +
                        ", requirement='" + requirement + '\'' +
                        '}';
            }

            @SerializedName("responsibility")
            private String responsibility;
            @SerializedName("requirement")
            private String requirement;

            public String getResponsibility() {
                return responsibility;
            }

            public void setResponsibility(String responsibility) {
                this.responsibility = responsibility;
            }

            public String getRequirement() {
                return requirement;
            }

            public void setRequirement(String requirement) {
                this.requirement = requirement;
            }
        }

        public class AddressBean {

            @SerializedName("metro")
            private Object metro;
            @SerializedName("street")
            private String street;
            @SerializedName("lat")
            private double lat;
            @SerializedName("description")
            private Object description;
            @SerializedName("id")
            private String id;
            @SerializedName("raw")
            private Object raw;
            @SerializedName("city")
            private String city;
            @SerializedName("building")
            private String building;
            @SerializedName("lng")
            private double lng;
            @SerializedName("metro_stations")
            private List<?> metroStations;

            public Object getMetro() {
                return metro;
            }

            public void setMetro(Object metro) {
                this.metro = metro;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public Object getDescription() {
                return description;
            }

            @Override
            public String toString() {
                return "AddressBean{" +
                        "metro=" + metro +
                        ", street='" + street + '\'' +
                        ", lat=" + lat +
                        ", description=" + description +
                        ", id='" + id + '\'' +
                        ", raw=" + raw +
                        ", city='" + city + '\'' +
                        ", building='" + building + '\'' +
                        ", lng=" + lng +
                        ", metroStations=" + metroStations +
                        '}';
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Object getRaw() {
                return raw;
            }

            public void setRaw(Object raw) {
                this.raw = raw;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getBuilding() {
                return building;
            }

            public void setBuilding(String building) {
                this.building = building;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public List<?> getMetroStations() {
                return metroStations;
            }

            public void setMetroStations(List<?> metroStations) {
                this.metroStations = metroStations;
            }
        }
    }
}
