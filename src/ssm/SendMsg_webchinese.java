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
post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//��ͷ�ļ�������ת��
String TextMessage ="�����ҵ��������������ǵ�����¶�ظ�������ҵ�ǣ�����ͷף����ǵ����ϲ���ձ��������ҵ�̹���й��٣����ǵ�������Ϭ�����������ҵ��ʺ��л��������ǵĹذ��鲻�Խ��������ҵ�ף�����˷�";
NameValuePair[] data ={ new NameValuePair("Uid", "���Լ����˻�"),new NameValuePair("Key", "�����KEY"),new NameValuePair("smsMob","���Ͷ��ŵĵ绰����"),new NameValuePair("smsText","��֤�룺"+TextMessage)};
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
System.out.println(result); //��ӡ������Ϣ״̬


post.releaseConnection();

}

}