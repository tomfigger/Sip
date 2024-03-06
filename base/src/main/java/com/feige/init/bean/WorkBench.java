package com.feige.init.bean;

import android.graphics.Color;

import com.alibaba.fastjson.annotation.JSONField;
import com.feige.init.R;

import java.io.Serializable;

public class WorkBench implements Serializable {

    @JSONField(name = "id")
    private String id;
    @JSONField(name = "ticketNo")
    private String ticketNo;
    @JSONField(name = "status")
    private Integer status;
    @JSONField(name = "statusName")
    private String statusName;
    @JSONField(name = "priority")
    private Integer priority;
    @JSONField(name = "priorityName")
    private String priorityName;
    @JSONField(name = "createTime")
    private String createTime;
    @JSONField(name = "isActivation")
    private Boolean isActivation;
    @JSONField(name = "problemDescription")
    private String problemDescription;
    @JSONField(name = "accountId")
    private String accountId;
    @JSONField(name = "accountName")
    private String accountName;
    @JSONField(name = "companyId")
    private Integer companyId;
    @JSONField(name = "createFrom")
    private Integer createFrom;
    @JSONField(name = "createFromName")
    private String createFromName;
    @JSONField(name = "creatorId")
    private Integer creatorId;
    @JSONField(name = "creatorName")
    private String creatorName;
    @JSONField(name = "creatorType")
    private Integer creatorType;
    @JSONField(name = "creatorTypeName")
    private String creatorTypeName;
    @JSONField(name = "customerEmail")
    private String customerEmail;
    @JSONField(name = "customerId")
    private Integer customerId;
    @JSONField(name = "customerName")
    private String customerName;
    @JSONField(name = "customerPhone")
    private String customerPhone;
    @JSONField(name = "extendInfomation")
    private String extendInfomation;
    @JSONField(name = "updateTime")
    private String updateTime;
    @JSONField(name = "isTips")
    private Boolean isTips;
    @JSONField(name = "isFocusOn")
    private Integer isFocusOn;
    @JSONField(name = "attachment")
    private String attachment;
    @JSONField(name = "attachments")
    private Object attachments;
    @JSONField(name = "companyName")
    private String companyName;
    @JSONField(name = "extendInfomations")
    private Object extendInfomations;
    @JSONField(name = "personLiableNames")
    private String personLiableNames;

    private String customerContactId;
    private String customerContactName;



    public String getCustomerContactId() {
        return customerContactId;
    }

    public void setCustomerContactId(String customerContactId) {
        this.customerContactId = customerContactId;
    }

    public String getCustomerContactName() {
        return customerContactName;
    }

    public void setCustomerContactName(String customerContactName) {
        this.customerContactName = customerContactName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsActivation() {
        return isActivation;
    }

    public void setIsActivation(Boolean isActivation) {
        this.isActivation = isActivation;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCreateFrom() {
        return createFrom;
    }

    public void setCreateFrom(Integer createFrom) {
        this.createFrom = createFrom;
    }

    public String getCreateFromName() {
        return createFromName;
    }

    public void setCreateFromName(String createFromName) {
        this.createFromName = createFromName;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Integer getCreatorType() {
        return creatorType;
    }

    public void setCreatorType(Integer creatorType) {
        this.creatorType = creatorType;
    }

    public String getCreatorTypeName() {
        return creatorTypeName;
    }

    public void setCreatorTypeName(String creatorTypeName) {
        this.creatorTypeName = creatorTypeName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getExtendInfomation() {
        return extendInfomation;
    }

    public void setExtendInfomation(String extendInfomation) {
        this.extendInfomation = extendInfomation;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsTips() {
        return isTips;
    }

    public void setIsTips(Boolean isTips) {
        this.isTips = isTips;
    }

    public Integer getIsFocusOn() {
        return isFocusOn;
    }

    public void setIsFocusOn(Integer isFocusOn) {
        this.isFocusOn = isFocusOn;
    }

    @JSONField(serialize = false)
    public int getStatusDrawable() {
//        状态（ 1、未分配 2、待处理 3、处理中 4、待回复 5、已解决 6、未解决 7、已废弃）
        if (status == null)
            return 0;
        switch (status) {
            case 1:
                return R.drawable.workbench_weifenpei;
            case 2:
                return R.drawable.workbench_daichuli;
            case 3:
                return R.drawable.workbench_chulizhong;
            case 4:
                return R.drawable.workbench_daihuifu;
            case 5:
                return R.drawable.workbench_yijiejue;
            case 6:
                return R.drawable.workbench_weijiejue;
            case 7:
                return R.drawable.workbench_yifeiqi;
        }
        return 0;
    }

    @JSONField(serialize = false)
    public int getStatusColor() {
        String colorStr = "";
        if (status == null)
            return 0;
        switch (status) {
            case 1:
            case 2:
            case 4:
                colorStr = "#FF8853";
                break;
            case 3:
                colorStr = "#29D67D";
                break;
            case 5:
                colorStr = "#558DFF";
                break;
            case 6:
                colorStr = "#8995A4";
                break;
            case 7:
                colorStr = "#FD5354";
                break;

        }
        return Color.parseColor(colorStr);
    }

    @JSONField(serialize = false)
    public String getStatusStr() {
//        状态（ 1、未分配 2、待处理 3、处理中 4、待回复 5、已解决 6、未解决 7、已废弃）
        if (status == null)
            return "";
        switch (status) {
            case 1:
                return "未分配";
            case 2:
                return "待处理";
            case 3:
                return "处理中";
            case 4:
                return "待回复";
            case 5:
                return "已解决";
            case 6:
                return "未解决";
            case 7:
                return "已废弃";
        }
        return "";
    }

    @JSONField(serialize = false)
    public String getPriorityStr() {
//        状态（ 1、未分配 2、待处理 3、处理中 4、待回复 5、已解决 6、未解决 7、已废弃）
        if (priority == null)
            return "";
        switch (priority) {
            case 1:
                return "低";
            case 2:
                return "中";
            case 3:
                return "高";
            case 4:
                return "紧急";
        }
        return "";
    }

    @JSONField(serialize = false)
    public int getPriorityback() {
//return "#29D67D";
//        低：#29D67D
//        中：#558DFF
//        高：#FF8853
//        紧急：#FD5354
//
        if (priority == null)
            return 0;
        switch (priority) {
            case 1:
                return Color.parseColor("#29D67D");
            case 2:
                return Color.parseColor("#558DFF");
            case 3:
                return Color.parseColor("#FF8853");
            case 4:
                return Color.parseColor("#FD5354");
        }
        return 0;
    }

    @JSONField(serialize = false)
    public int getPriorityDrawable() {
//        优先级（1、低 2、中 3、高 4、紧急）
        if (priority == null)
            return 0;
        switch (priority) {
            case 1:
                return R.drawable.workbench_low;
            case 2:
                return R.drawable.workbench_middle;
            case 3:
                return R.drawable.workbench_high;
            case 4:
                return R.drawable.workbench_jinji;
        }
        return 0;
    }

    @JSONField(serialize = false)
    public int getFocusDrawable() {
        switch (isFocusOn) {
            case 1:
                return R.drawable.workbench_fllow;

            case 2:
                return R.drawable.workbench_fllow_chekc;
        }
        return 0;
    }

    @JSONField(serialize = false)
    public String createFromStr() {
        if (createFrom == null)
            return "";
        switch (createFrom) {
            case 1:
                return "客服创建";
            case 2:
                return "我的客户";
            case 3:
                return "客户创建";
            case 4:
                return "语音呼叫";
        }
        return "";
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Object getAttachments() {
        return attachments;
    }

    public void setAttachments(Object attachments) {
        this.attachments = attachments;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Object getExtendInfomations() {
        return extendInfomations;
    }

    public void setExtendInfomations(Object extendInfomations) {
        this.extendInfomations = extendInfomations;
    }

    public String getPersonLiableNames() {
        return personLiableNames;
    }

    public void setPersonLiableNames(String personLiableNames) {
        this.personLiableNames = personLiableNames;
    }
}

