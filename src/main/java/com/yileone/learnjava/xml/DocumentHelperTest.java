package com.yileone.learnjava.xml;

import org.apache.commons.lang3.StringUtils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class DocumentHelperTest {
    public static void main(String[] args) {
        String xmlStr = "<?xml version = \"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<DOCUMENT>\n" +
                "\t<RETURN_CODE>000000</RETURN_CODE>\n" +
                "    <RETURN_MSG></RETURN_MSG>\n" +
                "\t<CURPAGE>1</CURPAGE>\n" +
                "\t<PAGECOUNT>1</PAGECOUNT>\n" +
                "\t<TOTAL>1</TOTAL>\n" +
                "\t<PAYAMOUNT>0.00</PAYAMOUNT>\n" +
                "\t<REFUNDAMOUNT>0.00</REFUNDAMOUNT>\n" +
                "\n" +
                "\t<QUERYORDER>\n" +
                "\t\t<MERCHANTID>105002453995890</MERCHANTID>\n" +
                "\t\t<BRANCHID>330000000</BRANCHID>\n" +
                "\t\t<POSID>039358073</POSID>\n" +
                "\t\t<ORDERID>627838114626928640</ORDERID>\n" +
                "\t\t<ORDERDATE>20190929120440</ORDERDATE>\n" +
                "\t\t<ACCDATE>20190929</ACCDATE>\n" +
                "\t\t<AMOUNT>0.01</AMOUNT>\n" +
                "\t\t<STATUSCODE>1</STATUSCODE>\n" +
                "\t\t<STATUS>成功</STATUS>\n" +
                "\t\t\n" +
                "\t\t<REFUND>0.00</REFUND>\n" +
                "\t\t<SIGN>209f4addc6ccea9a6393ced1f341084a14cd52e850a892b9c9ab5b5f0b13f55630d4798fb6ee29b116d74077a3ecd29e8f38787d096077ce0c2a134bfffd7855dc620313d622117963a7f1fff114b389afea32ae107d52f651db37a6ea720239de11f885fbf75dc0dbad1313f932ac269e61a93ddb1db7ebaefc28c2c6d30c68</SIGN>\n" +
                "\t</QUERYORDER>\n" +
                "\n" +
                "</DOCUMENT>";

        String ss = "\n" +
                "\n" +
                "<?xml version = \"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<DOCUMENT>\n" +
                "\t<RETURN_CODE>000000</RETURN_CODE>\n" +
                "    <RETURN_MSG></RETURN_MSG>\n" +
                "\t<CURPAGE>1</CURPAGE>\n" +
                "\t<PAGECOUNT>1</PAGECOUNT>\n" +
                "\t<TOTAL>1</TOTAL>\n" +
                "\t<PAYAMOUNT>0.00</PAYAMOUNT>\n" +
                "\t<REFUNDAMOUNT>0.00</REFUNDAMOUNT>\n" +
                "\n" +
                "\t<QUERYORDER>\n" +
                "\t\t<MERCHANTID>105002453995890</MERCHANTID>\n" +
                "\t\t<BRANCHID>330000000</BRANCHID>\n" +
                "\t\t<POSID>039358073</POSID>\n" +
                "\t\t<ORDERID>627838114626928640</ORDERID>\n" +
                "\t\t<ORDERDATE>20190929120440</ORDERDATE>\n" +
                "\t\t<ACCDATE>20190929</ACCDATE>\n" +
                "\t\t<AMOUNT>0.01</AMOUNT>\n" +
                "\t\t<STATUSCODE>1</STATUSCODE>\n" +
                "\t\t<STATUS>成功</STATUS>\n" +
                "\t\t\n" +
                "\t\t<REFUND>0.00</REFUND>\n" +
                "\t\t<SIGN>209f4addc6ccea9a6393ced1f341084a14cd52e850a892b9c9ab5b5f0b13f55630d4798fb6ee29b116d74077a3ecd29e8f38787d096077ce0c2a134bfffd7855dc620313d622117963a7f1fff114b389afea32ae107d52f651db37a6ea720239de11f885fbf75dc0dbad1313f932ac269e61a93ddb1db7ebaefc28c2c6d30c68</SIGN>\n" +
                "\t</QUERYORDER>\n" +
                "\n" +
                "</DOCUMENT>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n";
        ccbQueryResultParse(ss.trim());



    }

    // 解析建行聚合支付查单结果报文，并返回支付结果
    private static void ccbQueryResultParse(String queryRes){
        Document document = null;
        try {
            document = DocumentHelper.parseText(queryRes);
        } catch (DocumentException e) {
            System.out.println("建行聚合支付查单解析document失败");
        }
        Element rootElement = document.getRootElement();
        Element returnCodeElement = rootElement.element("RETURN_CODE");

        // 如果是流水记录不存在的,直接返回未支付
        if (StringUtils.equals("0130Z110W100", returnCodeElement.getStringValue())) {
            System.out.println("建行聚合支付查单流水记录当前查询操作员不存在:{}");
        }

        // 查单未成功
        if (returnCodeElement == null || !StringUtils.equals("000000", returnCodeElement.getStringValue())) {
            System.out.println("建行聚合支付查单返回非成功,错误信息:{}");
        }

        Element orderElement = rootElement.element("QUERYORDER");
        Element orderStatusElement = orderElement.element("STATUSCODE");
        if (orderStatusElement == null) {
            System.out.println("建行聚合支付查单发生异常");
        }
        String status = orderStatusElement.getStringValue();
        // 支付流水状态码 -> 支付流水状态
        // STATUSCODE：0      STATUS:失败
        // STATUSCODE：1      STATUS:成功
        // STATUSCODE：2      STATUS:待银行确认
        // STATUSCODE：3      STATUS:已部分退款
        // STATUSCODE：4      STATUS:已全额退款
        // STATUSCODE：5      STATUS:待银行确认
        if (StringUtils.equals(status, "1") || StringUtils.equals(status, "3") || StringUtils.equals("4", status)) {
            System.out.println("建行聚合支付查单 支付成功");
        } else {
            System.out.println("建行聚合支付查单 失败");
        }
    }
}
