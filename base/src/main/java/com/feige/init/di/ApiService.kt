package com.feige.init.di

import cn.feige.apilibrary.base.ApiServiceBase
import cn.feige.apilibrary.base.BaseDataBean
import cn.feige.apilibrary.base.Constants
import cn.feige.apilibrary.base.bean.LoginInfo
import com.alibaba.fastjson.JSONObject
import com.feige.init.base.BaseResultBean
import com.feige.init.bean.*
import com.feige.init.utils.ClientTag
import io.reactivex.Flowable
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.ArrayList

/**
 * MrLiu253@163.com
 * @time 1/17/22
 * 描述:
 */
interface ApiService : ApiServiceBase {
    @POST(Constants.API_URL + "User/Login")
    fun login(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<LoginInfo>>>

    @POST("Company/Register")
    fun regist(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST(Constants.API_URL + "User/SetPassword")
    fun resetPasswordByCode(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST(Constants.API_URL + "Common/GetSmsCode")
    fun sendSmsCode(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Common/SendSmsCode")
    fun sendRegistSmsCode(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST(Constants.API_URL + "User/Logout")
    fun logout(): Flowable<Response<BaseDataBean<String>>>

    @POST("Common/Upload")
    fun uploadImage(@Body body: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Account/UpdateHeadImg")
    fun modifyAvatar(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Account/UpdatePersionInfo")
    fun modifyUserInfo(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Account/GetWelcomes")
    fun getWelcome(): Flowable<Response<BaseDataBean<List<WelcomeBeanItem>>>>

    @POST("Account/UpdateWelcomes")
    fun modifyWelcome(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Account/UpdatePassword")
    fun changePassword(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Account/GetDepartmentAccounts")
    fun getTransferList(): Flowable<Response<BaseDataBean<List<TransgerBean>>>>

    @POST("Account/GetDepartmentOnLineAccounts")
    fun getOnlineTransferList(): Flowable<Response<BaseDataBean<List<TransgerBean>>>>

    @POST("ChatSetting/GetReply")
    fun getReplyList(): Flowable<Response<BaseDataBean<ReplyBean>>>

    @POST("Account/GetAccountInfo")
    fun getUserInfo(): Flowable<Response<BaseDataBean<AccountInfoDto>>>

    @POST("Customer/AddCustomer")
    fun saveVisitorInfo(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("m/Customer/GetCustomerList")
    fun customerList(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<Page<ClientBean>>>>

    @POST("m/Customer/GetPublicCustomerList")
    fun publicClientList(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<Page<ClientBean>>>>

    @POST("Customer/GetCustomer")
    fun getCustomer(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<ClientDetailDto>>>

    @POST("Customer/GetCustomer")
    fun customerMap(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<Map<String, Object>>>>

    @POST("Customer/GetCustomer")
    fun customerTags(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<ClientTag>>>>

    @POST("m/Customer/GetFollowRecords")
    fun followRecords(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<Page<FllowPlanBean>>>>

    @POST("voice/GetCallRecordByCustomerId")
    fun callRecord(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<PageList<CallRecordBean>>>>

    @POST("m/Voice/GetCallRecord")
    fun voiceGetCallRecord(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<Page<CallRecordBean>>>>

    @POST("Customer/GetBrowseRecords")
    fun brownRecord(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<BrownRecord>>>>

    @POST("Customer/GetOperationRecords")
    fun opretorRecord(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<OpretorRecordBean>>>>

    @POST(Constants.API_URL + "Common/SmsCodeVerification")
    fun smsCodeVerification(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Account/CheckedCode")
    fun checkedCode(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Common/SmsCodeVerificationAsync")
    fun smsCodeVerificationAsync(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Company/GetCompanyFiledListByCompanyId")
    fun companyFiledListByCompanyId(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<ArrayList<CompanyFiled>>>>

    @POST("Customer/UpdateCustomer")
    fun updateCustomer(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Common/GetRegionListByParentCode/{code}")
    fun regionListByParentCode(@Path("code") code: String): Flowable<Response<BaseDataBean<List<CityBean>>>>

    @POST("Customer/AddCustomer")
    fun addCustomer(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Customer/UpdateFollowRecord")
    fun updateFollowRecord(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Customer/AddFollowRecord")
    fun addFollowRecord(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Customer/GetCustomerTags")
    fun customerAllTags(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<TagBean>>>>

    @POST("Customer/UpdateCustomerTagInfo")
    fun updateCustomerTagInfo(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>


    @POST("DropDown/GetSeatByAuth")
    fun seatByAuth(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<SeatBean>>>>

    @POST("Organization/GetGetDepartmentAndSeatList")
    fun departmentAndSeatList(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<OrganizeBean>>>>

    @POST("Customer/TransferCuestomer")
    fun toGonghai(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Customer/GetGuestbookList")
    fun guestbookList(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<Page<LeaveMessage>>>>

    @POST("m/Guest/GetGuest")
    fun visitorData(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<VisitorBean>>>

    @POST("Account/GetColleagueList")
    fun colleagueList(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<OrganizeBean>>>>

    @POST("ChatSetting/GetReply")
    fun quickReplyList(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<QuickReplayDto>>>

    @POST("Customer/GuestToCustomer")
    fun guestToCustomer(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Company/GetCompany")
    fun companyInfo(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<CompanyInfo>>>

    @POST("Customer/HandleGuestbook")
    fun handleGuestbook(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Customer/DeleteFollowRecord")
    fun fllowDelete(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Website/GetWebsiteRuleInfo")
    fun websiteRuleInfo(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<WebSiteRuleInfo>>>>

    @POST("Website/GetTemplateByWebsiteId")
    fun templateByWebsiteId(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<TemplateResult>>>

    @POST("Voice/GetPlaceOwnership")
    fun placeOwnership(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<PhoneBelong>>>

    @POST("Customer/AddBlacklistVisitor")
    fun addBlacklistVisitor(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Guest/GetChatListGuestInfo")
    fun chatListGuestInfo(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<VisitorBean.GuestBean>>>>

    @POST("Voice/Call")
    fun voiceCall(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<CallVoiceDto>>>

    @POST("Account/SetDeviceToken")
    fun deviceToken(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Account/GetColleagueChatMessage")
    fun colleagueChatMessage(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<String>>>>

    @POST("Account/GetAccountById")
    fun accountById(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<OrganizeBean>>>

    @POST("Voice/GetNumber")
    fun callRecordNumber(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<Map<String, String>>>>

    @POST("Account/CancellationAccount")
    fun cancellationAccount(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<Map<String, String>>>>

    @POST("Account/Report")
    fun reportVisitor(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Account/GetOfflineMessage")
    fun visitorOfflineChatMessage(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<String>>>>

    @POST("Account/GetRoomLastMessage")
    fun roomLastMessage(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<Map<String, String>>>>>

    @POST(Constants.CALLCENTER_URL + "agent/extension/device/bind")
    fun extensionDeviceBind(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("System/GetMessageInboxes")
    fun sationMessages(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<Page<StationMessage>>>>

    @POST("System/ReadMessage")
    fun readAllmessage(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("System/GetNotReadCount")
    fun notStationMessageReadCount(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<Map<String, Object>>>>

    @POST("Ticket/GetWorkBench")
    fun workBenchStatics(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<Map<String, String>>>>

    @POST("Ticket/GetTicketList")
    fun workBenchList(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<Page<WorkBench>>>>

    @POST("Ticket/GetMyTicketList")
    fun myTicketList(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<Page<WorkBench>>>>

    @POST("Ticket/GetTicketReplyList")
    fun ticketReplyList(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<WorkBenchReplay>>>>

    @POST("Ticket/GetTicketInfoById")
    fun ticketInfoById(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<WorkBench>>>

    @POST("Ticket/GetTicketOperationList")
    fun ticketOperationList(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<WorkBenchOpretor>>>>

    @POST("Ticket/AddTicketReplyByCustomerService")
    fun addTicketReplyByCustomerService(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Ticket/AddTicket")
    fun addTicket(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Ticket/GetTicketTemplateExtends")
    fun ticketTemplateExtends(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<BaseResultBean<List<ExtendInfomation>>>>>

    @POST("DropDown/GetTicketTemplateOptions")
    fun ticketTemplateOptions(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<JSONObject>>>>

    @POST("Ticket/UpdateTicket")
    fun edtTicket(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Ticket/TicketOperation")
    fun ticketFollow(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Ticket/TicketSaveCustomer")
    fun ticketSaveCustomer(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("System/UpdateApp")
    fun updateApp(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<AppVersionDto>>>

    @POST("m/Customer/UpdateCustomerContact")
    fun updateConcat(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Company/GetCompanyCustomerContactFileds")
    fun companyCustomerContactFileds(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<CustomerContactFileds>>>>

    @POST("m/Customer/DeleteCustomerContact")
    fun deleteConcat(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Customer/GetCusetomerContactByCustomerId")
    fun cusetomerContactByCustomerId(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<List<ClientConcat>>>>

    @POST("m/Customer/AddCustomerContact")
    fun addCustomerContact(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<String>>>

    @POST("Report/GetAppHomeData")
    fun appHomeData(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<JSONObject>>>

    @POST("System/RandomSentence")
    fun randomSentence(@Body requestBody: RequestBody): Flowable<Response<BaseDataBean<JSONObject>>>
}