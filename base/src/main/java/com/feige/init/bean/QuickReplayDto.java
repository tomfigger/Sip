package com.feige.init.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuickReplayDto {

    @SerializedName("general")
    private List<GeneralDTO> general;
    @SerializedName("personal")
    private List<GeneralDTO> personal;

    public List<GeneralDTO> getGeneral() {
        return general;
    }

    public void setGeneral(List<GeneralDTO> general) {
        this.general = general;
    }

    public List<GeneralDTO> getPersonal() {
        return personal;
    }

    public void setPersonal(List<GeneralDTO> personal) {
        this.personal = personal;
    }

    public static class GeneralDTO {

        @SerializedName("accountId")
        private Integer accountId;
        @SerializedName("groupName")
        private String groupName;
        @SerializedName("replyContentDtos")
        private List<ReplyContentDtosDTO> replyContentDtos;

        public Integer getAccountId() {
            return accountId;
        }

        public void setAccountId(Integer accountId) {
            this.accountId = accountId;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public List<ReplyContentDtosDTO> getReplyContentDtos() {
            return replyContentDtos;
        }

        public void setReplyContentDtos(List<ReplyContentDtosDTO> replyContentDtos) {
            this.replyContentDtos = replyContentDtos;
        }

        public static class ReplyContentDtosDTO implements Parcelable {

            @SerializedName("title")
            private String title;
            @SerializedName("content")
            private String content;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.title);
                dest.writeString(this.content);
            }

            public void readFromParcel(Parcel source) {
                this.title = source.readString();
                this.content = source.readString();
            }

            public ReplyContentDtosDTO() {
            }

            protected ReplyContentDtosDTO(Parcel in) {
                this.title = in.readString();
                this.content = in.readString();
            }

            public static final Creator<ReplyContentDtosDTO> CREATOR = new Creator<ReplyContentDtosDTO>() {
                @Override
                public ReplyContentDtosDTO createFromParcel(Parcel source) {
                    return new ReplyContentDtosDTO(source);
                }

                @Override
                public ReplyContentDtosDTO[] newArray(int size) {
                    return new ReplyContentDtosDTO[size];
                }
            };
        }
    }
}
