package me.vpineda.request.test;

import me.vpineda.request.CourseFactory;
import me.vpineda.request.Request;
import me.vpineda.util.Terminal;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vpineda1996 on 2015-05-19.
 */
public class RequestTest extends Request {
    String jsession,scriptSession;
    Request.Type type;
    Request request;
    String xhrCourses, xhrSections;

    public RequestTest(Terminal terminal) {
        super(terminal);
    }

    @Before
    public void setUp() throws Exception {
        // Some arguments so SSL can work
        System.setProperty("jsse.enableSNIExtension", "false");

        jsession = "A3F8B7E95528ABF1930174DE63C2E019";
        scriptSession = "67F19284FB9DEB3A907E3F62B2B5AAA2846";
        type = new Request.Type(Request.Operation.SUBJECTS);
        type.setSession("2014W");
        setupXHR();
    }
    private void setupXHR() {
        xhrCourses = "throw 'allowScriptTagRemoting is false.';\n" +
                "//#DWR-INSERT\n" +
                "//#DWR-REPLY\n" +
                "var s0={};var s1={};var s2={};var s3={};var s4={};var s5={};var s6={};var s7={};var s8={};var s9={};var s10={};var s11={};var s12={};var s13={};var s14={};var s15={};var s16={};var s17={};var s18={};var s19={};var s20={};var s21={};var s22={};var s23={};var s24={};var s25={};var s26={};var s27={};var s28={};var s29={};var s30={};var s31={};var s32={};var s33={};var s34={};var s35={};var s36={};var s37={};var s38={};var s39={};var s40={};var s41={};var s42={};var s43={};var s44={};var s45={};var s46={};var s47={};var s48={};var s49={};var s50={};var s51={};var s52={};var s53={};var s54={};var s55={};var s56={};var s57={};var s58={};var s59={};var s60={};var s61={};var s62={};var s63={};var s64={};var s65={};var s66={};var s67={};var s68={};var s69={};var s70={};var s71={};var s72={};var s73={};var s74={};var s75={};var s76={};var s77={};var s78={};var s79={};var s80={};var s81={};var s82={};var s83={};var s84={};var s85={};var s86={};var s87={};var s88={};var s89={};var s90={};var s91={};var s92={};var s93={};var s94={};var s95={};var s96={};var s97={};var s98={};var s99={};s0.label=\"\";s0.value=\"\";\n" +
                "s1.label=\"101\";s1.value=\"101\";\n" +
                "s2.label=\"110\";s2.value=\"110\";\n" +
                "s3.label=\"121\";s3.value=\"121\";\n" +
                "s4.label=\"189\";s4.value=\"189\";\n" +
                "s5.label=\"210\";s5.value=\"210\";\n" +
                "s6.label=\"213\";s6.value=\"213\";\n" +
                "s7.label=\"221\";s7.value=\"221\";\n" +
                "s8.label=\"259\";s8.value=\"259\";\n" +
                "s9.label=\"260\";s9.value=\"260\";\n" +
                "s10.label=\"261\";s10.value=\"261\";\n" +
                "s11.label=\"298\";s11.value=\"298\";\n" +
                "s12.label=\"299\";s12.value=\"299\";\n" +
                "s13.label=\"301\";s13.value=\"301\";\n" +
                "s14.label=\"302\";s14.value=\"302\";\n" +
                "s15.label=\"303\";s15.value=\"303\";\n" +
                "s16.label=\"304\";s16.value=\"304\";\n" +
                "s17.label=\"310\";s17.value=\"310\";\n" +
                "s18.label=\"311\";s18.value=\"311\";\n" +
                "s19.label=\"312\";s19.value=\"312\";\n" +
                "s20.label=\"313\";s20.value=\"313\";\n" +
                "s21.label=\"314\";s21.value=\"314\";\n" +
                "s22.label=\"317\";s22.value=\"317\";\n" +
                "s23.label=\"319\";s23.value=\"319\";\n" +
                "s24.label=\"320\";s24.value=\"320\";\n" +
                "s25.label=\"322\";s25.value=\"322\";\n" +
                "s26.label=\"340\";s26.value=\"340\";\n" +
                "s27.label=\"344\";s27.value=\"344\";\n" +
                "s28.label=\"349\";s28.value=\"349\";\n" +
                "s29.label=\"398\";s29.value=\"398\";\n" +
                "s30.label=\"399\";s30.value=\"399\";\n" +
                "s31.label=\"402\";s31.value=\"402\";\n" +
                "s32.label=\"404\";s32.value=\"404\";\n" +
                "s33.label=\"406\";s33.value=\"406\";\n" +
                "s34.label=\"410\";s34.value=\"410\";\n" +
                "s35.label=\"411\";s35.value=\"411\";\n" +
                "s36.label=\"415\";s36.value=\"415\";\n" +
                "s37.label=\"416\";s37.value=\"416\";\n" +
                "s38.label=\"417\";s38.value=\"417\";\n" +
                "s39.label=\"418\";s39.value=\"418\";\n" +
                "s40.label=\"420\";s40.value=\"420\";\n" +
                "s41.label=\"421\";s41.value=\"421\";\n" +
                "s42.label=\"422\";s42.value=\"422\";\n" +
                "s43.label=\"424\";s43.value=\"424\";\n" +
                "s44.label=\"425\";s44.value=\"425\";\n" +
                "s45.label=\"426\";s45.value=\"426\";\n" +
                "s46.label=\"430\";s46.value=\"430\";\n" +
                "s47.label=\"444\";s47.value=\"444\";\n" +
                "s48.label=\"445\";s48.value=\"445\";\n" +
                "s49.label=\"448\";s49.value=\"448\";\n" +
                "s50.label=\"449\";s50.value=\"449\";\n" +
                "s51.label=\"490\";s51.value=\"490\";\n" +
                "s52.label=\"499\";s52.value=\"499\";\n" +
                "s53.label=\"500\";s53.value=\"500\";\n" +
                "s54.label=\"501\";s54.value=\"501\";\n" +
                "s55.label=\"502\";s55.value=\"502\";\n" +
                "s56.label=\"503\";s56.value=\"503\";\n" +
                "s57.label=\"504\";s57.value=\"504\";\n" +
                "s58.label=\"505\";s58.value=\"505\";\n" +
                "s59.label=\"506\";s59.value=\"506\";\n" +
                "s60.label=\"507\";s60.value=\"507\";\n" +
                "s61.label=\"508\";s61.value=\"508\";\n" +
                "s62.label=\"509\";s62.value=\"509\";\n" +
                "s63.label=\"511\";s63.value=\"511\";\n" +
                "s64.label=\"513\";s64.value=\"513\";\n" +
                "s65.label=\"514\";s65.value=\"514\";\n" +
                "s66.label=\"515\";s66.value=\"515\";\n" +
                "s67.label=\"516\";s67.value=\"516\";\n" +
                "s68.label=\"517\";s68.value=\"517\";\n" +
                "s69.label=\"520\";s69.value=\"520\";\n" +
                "s70.label=\"521\";s70.value=\"521\";\n" +
                "s71.label=\"522\";s71.value=\"522\";\n" +
                "s72.label=\"524\";s72.value=\"524\";\n" +
                "s73.label=\"525\";s73.value=\"525\";\n" +
                "s74.label=\"526\";s74.value=\"526\";\n" +
                "s75.label=\"527\";s75.value=\"527\";\n" +
                "s76.label=\"530\";s76.value=\"530\";\n" +
                "s77.label=\"531\";s77.value=\"531\";\n" +
                "s78.label=\"532\";s78.value=\"532\";\n" +
                "s79.label=\"533\";s79.value=\"533\";\n" +
                "s80.label=\"534\";s80.value=\"534\";\n" +
                "s81.label=\"535\";s81.value=\"535\";\n" +
                "s82.label=\"536\";s82.value=\"536\";\n" +
                "s83.label=\"538\";s83.value=\"538\";\n" +
                "s84.label=\"539\";s84.value=\"539\";\n" +
                "s85.label=\"540\";s85.value=\"540\";\n" +
                "s86.label=\"542\";s86.value=\"542\";\n" +
                "s87.label=\"543\";s87.value=\"543\";\n" +
                "s88.label=\"544\";s88.value=\"544\";\n" +
                "s89.label=\"545\";s89.value=\"545\";\n" +
                "s90.label=\"546\";s90.value=\"546\";\n" +
                "s91.label=\"547\";s91.value=\"547\";\n" +
                "s92.label=\"548\";s92.value=\"548\";\n" +
                "s93.label=\"549\";s93.value=\"549\";\n" +
                "s94.label=\"550\";s94.value=\"550\";\n" +
                "s95.label=\"554\";s95.value=\"554\";\n" +
                "s96.label=\"564\";s96.value=\"564\";\n" +
                "s97.label=\"589\";s97.value=\"589\";\n" +
                "s98.label=\"590\";s98.value=\"590\";\n" +
                "s99.label=\"649\";s99.value=\"649\";\n" +
                "dwr.engine._remoteHandleCallback('6','0',[s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,s29,s30,s31,s32,s33,s34,s35,s36,s37,s38,s39,s40,s41,s42,s43,s44,s45,s46,s47,s48,s49,s50,s51,s52,s53,s54,s55,s56,s57,s58,s59,s60,s61,s62,s63,s64,s65,s66,s67,s68,s69,s70,s71,s72,s73,s74,s75,s76,s77,s78,s79,s80,s81,s82,s83,s84,s85,s86,s87,s88,s89,s90,s91,s92,s93,s94,s95,s96,s97,s98,s99]);\n";
        xhrSections = "throw 'allowScriptTagRemoting is false.';\n" +
                "//#DWR-INSERT\n" +
                "//#DWR-REPLY\n" +
                "var s0={};var s1={};var s2={};var s3={};var s4={};var s5={};var s6={};var s7={};var s8={};var s9={};var s10={};var s11={};var s12={};var s13={};var s14={};var s15={};var s16={};var s17={};var s18={};var s19={};var s20={};var s21={};var s22={};var s23={};var s24={};var s25={};var s26={};var s27={};var s28={};var s29={};var s30={};var s31={};var s32={};var s33={};var s34={};var s35={};s0.label=\"101\";s0.value=\"101\";\n" +
                "s1.label=\"102\";s1.value=\"102\";\n" +
                "s2.label=\"1W1\";s2.value=\"1W1\";\n" +
                "s3.label=\"1W2\";s3.value=\"1W2\";\n" +
                "s4.label=\"201\";s4.value=\"201\";\n" +
                "s5.label=\"202\";s5.value=\"202\";\n" +
                "s6.label=\"2W1\";s6.value=\"2W1\";\n" +
                "s7.label=\"2W2\";s7.value=\"2W2\";\n" +
                "s8.label=\"BCS\";s8.value=\"BCS\";\n" +
                "s9.label=\"L1A\";s9.value=\"L1A\";\n" +
                "s10.label=\"L1B\";s10.value=\"L1B\";\n" +
                "s11.label=\"L1C\";s11.value=\"L1C\";\n" +
                "s12.label=\"L1D\";s12.value=\"L1D\";\n" +
                "s13.label=\"L1E\";s13.value=\"L1E\";\n" +
                "s14.label=\"L1F\";s14.value=\"L1F\";\n" +
                "s15.label=\"L1G\";s15.value=\"L1G\";\n" +
                "s16.label=\"L1H\";s16.value=\"L1H\";\n" +
                "s17.label=\"L1J\";s17.value=\"L1J\";\n" +
                "s18.label=\"L1K\";s18.value=\"L1K\";\n" +
                "s19.label=\"L1M\";s19.value=\"L1M\";\n" +
                "s20.label=\"L1N\";s20.value=\"L1N\";\n" +
                "s21.label=\"L1P\";s21.value=\"L1P\";\n" +
                "s22.label=\"L2A\";s22.value=\"L2A\";\n" +
                "s23.label=\"L2B\";s23.value=\"L2B\";\n" +
                "s24.label=\"L2C\";s24.value=\"L2C\";\n" +
                "s25.label=\"L2D\";s25.value=\"L2D\";\n" +
                "s26.label=\"L2E\";s26.value=\"L2E\";\n" +
                "s27.label=\"L2F\";s27.value=\"L2F\";\n" +
                "s28.label=\"L2G\";s28.value=\"L2G\";\n" +
                "s29.label=\"L2H\";s29.value=\"L2H\";\n" +
                "s30.label=\"L2J\";s30.value=\"L2J\";\n" +
                "s31.label=\"L2M\";s31.value=\"L2M\";\n" +
                "s32.label=\"L2N\";s32.value=\"L2N\";\n" +
                "s33.label=\"L2P\";s33.value=\"L2P\";\n" +
                "s34.label=\"L2Q\";s34.value=\"L2Q\";\n" +
                "s35.label=\"L2R\";s35.value=\"L2R\";\n" +
                "dwr.engine._remoteHandleCallback('8','0',[s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,s29,s30,s31,s32,s33,s34,s35]);";
    }

    @Test
    public void testRequestXHR() throws Exception {
//        System.out.println(Request.requestXHR(jsession,scriptSession,type));

//        Thread.sleep(5000);

        type = new Request.Type(Request.Operation.COURSES);
        type.setSession("2014W");
        type.setSubject("CPSC");
//
        System.out.println(Request.requestXHR(jsession, scriptSession, type));

//        Thread.sleep(5000);
//
        type.setOp(Request.Operation.SECTIONS);
        type.setCourse("210");

    }

    @Test
    public void testStartCrawling() throws Exception {
        CourseFactory.getInstance().fillInFactory("2014W",jsession,scriptSession);
        request = new RequestTest(Terminal.parseArguments(new String[]{
                "-c", "CPSC", "-n", "210"
        }));
        try {
            request.startCrawling();
        }catch (Exception e){e.printStackTrace();}

        Thread.sleep(5000);

        request = new RequestTest(Terminal.parseArguments(new String[]{
                "-c", "CPSC"
        }));
        try {
            request.startCrawling();
        }catch (Exception e){e.printStackTrace();}

        Thread.sleep(5000);

        request = new RequestTest(Terminal.parseArguments(new String[]{}));
        try {
            request.startCrawling();
        }catch (Exception e){e.printStackTrace();}

    }

    @Test
    public void testParseCourses() throws Exception{
        request = new RequestTest(Terminal.parseArguments(new String[]{
                "-c", "CPSC", "-n", "210"
        }));
        request.parseCourses(xhrCourses);
        request.parseSections(xhrSections);
    }

    @Test
    public void testCaptchaResponse() throws Exception {
        Request r = new RequestTest(Terminal.parseArguments(new String[]{}));
        r.jsessionid = jsession;
        r.getCaptchaResponse();
        r.getCaptchaResponse();
    }
}