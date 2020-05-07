package com.wxs.request;

import okhttp3.*;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-12-04
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class UpdateData {

    public static void main(String[] args) throws  Exception{

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        RequestBody body = RequestBody.create(mediaType, "{\"objectData\":{\"map\":{\"object_describe_api_name\":\"project\",\"id\":\"5ddf63af3d7fcd03d995dc5d\",\"currency_unit\":\"CNY\"}}}");
        Request request = new Request.Builder()
                .url("https://investment-sh.jingdata.com/api/metadata/data/updatePartData")
                .post(body)
                .addHeader("connection", "keep-alive")
                .addHeader("pragma", "no-cache")
                .addHeader("cache-control", "no-cache")
                .addHeader("accept", "application/json, text/plain, */*")
                .addHeader("origin", "https://investment-sh.jingdata.com")
                .addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36")
                .addHeader("content-type", "application/json;charset=UTF-8")
                .addHeader("sec-fetch-site", "same-origin")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("referer", "https://investment-sh.jingdata.com/")
                .addHeader("accept-encoding", "gzip, deflate, br")
                .addHeader("accept-language", "zh-CN,zh;q=0.9")
                .addHeader("cookie", "acw_tc=276aedec15754447718965645e288fbb076b82c666e72347c43435457358eb; saas_login_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJ1c2VyX2lkIjoiNWMwZmE1MTZmMzhhNGMwOTQ0OWJhYWYyOjVjMGZhNWI5YjcxOTFiNzM1NmY5MDUzNToxMzgwMDEzODAwMCIsImlzcyI6IkppbmdkYXRhIiwiZXhwIjoxNTc2MzA4NzQyLCJpYXQiOjE1NzU0NDQ3NDJ9.3EYQU1gnbp_vuESsCVOs1xZ5LfZ7E4U9pmRjEnwiN-g")
                .addHeader("postman-token", "b569aa2e-32d3-31d2-b83f-d3f7e3915aa2")
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(request);
    }



    String str = "";
}
