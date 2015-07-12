package ssm;

import java.util.Date;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsg_webchinese {

public static void main(String[] args)throws Exception
{

HttpClient client = new HttpClient();
PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn"); 
post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
String TextMessage ="你在我的心中扎根，我们的友谊露重更深；你在我的牵挂中缤纷，我们的情感喜大普奔；你在我的坦诚中光临，我们的心有灵犀更近；你在我的问候中欢欣，我们的关爱情不自禁；你在我的祝福中兴奋";
NameValuePair[] data ={ new NameValuePair("Uid", "你自己的账户"),new NameValuePair("Key", "申请的KEY"),new NameValuePair("smsMob","发送短信的电话号码"),new NameValuePair("smsText","验证码："+TextMessage)};
System.err.println(new Date());
post.setRequestBody(data);

client.executeMethod(post);
Header[] headers = post.getResponseHeaders();
int statusCode = post.getStatusCode();
System.out.println("statusCode:"+statusCode);
for(Header h : headers)
{
System.out.println(h.toString());
}
String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
System.out.println(result); //打印返回消息状态


post.releaseConnection();

}

}