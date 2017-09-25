package com.id.tmli.intranet.controller;

import com.id.tmli.intranet.common.ResponseBody;
import com.id.tmli.intranet.model.form.DailySubmissionForm;
import com.id.tmli.intranet.service.DailySubmissionService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/submission")
public class DailySubmissionController {

    @Autowired
    @Qualifier("dailySubmissionService")
    private DailySubmissionService dailySubmissionService;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return JSON Format for Message Response
     */
    final Logger log = Logger.getLogger(DailySubmissionController.class);
    final ObjectMapper dataMapper = new ObjectMapper();


    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSubmission(@Valid DailySubmissionForm data) throws IOException, RuntimeException {

        String message = "";

        ResponseBody responseBody = new ResponseBody();
        try {
            log.info("++++++++++++++++++++++++++++");
            log.info("Data Submission JSON : ");
            log.info("++++++++++++++++++++++++++++");
            log.info("branch_id :" + data.getBranch_id() + ";");
            log.info("user_upload :" + data.getUser_upload() + ";");
            log.info("agent_code :" + data.getAgent_code() + ";");
            log.info("policy_holder :" + data.getPolicy_holder() + ";");
            log.info("insured :" + data.getPolicy_holder() + ";");
            log.info("phone_no :" + data.getPhone_no() + ";");
            log.info("email :" + data.getEmail() + ";");
            log.info("spaj_no :" + data.getSpaj_no() + ";");
            log.info("paymode :" + data.getPaymode() + ";");
            log.info("product_id :" + data.getProduct_id() + ";");
            log.info("currency :" + data.getCurrency() + ";");
            log.info("premium :" + data.getPremium() + ";");
            log.info("top_reg :" + data.getTop_reg() + ";");
            log.info("top_sekaligus :" + data.getTop_sekaligus() + ";");
            log.info("spaj_no :" + data.getSpaj_no() + ";");
            log.info("spaj_a1 :" + data.getSpaj_a1() + ";");
            log.info("spaj_a2 :" + data.getSpaj_a2() + ";");
            log.info("spaj_a3 :" + data.getSpaj_a3() + ";");
            log.info("spaj_a4 :" + data.getSpaj_a4() + ";");
            log.info("spaj_a5 :" + data.getSpaj_a5() + ";");
            log.info("spaj_b1 :" + data.getSpaj_b1() + ";");
            log.info("spaj_b2 :" + data.getSpaj_b2() + ";");
            log.info("spaj_b3 :" + data.getSpaj_b3() + ";");
            log.info("spaj_b4 :" + data.getSpaj_b4() + ";");
            log.info("spaj_b4 :" + data.getSpaj_b5() + ";");
            log.info("birth_date_user :" + data.getBirth_date_user() + ";");
            log.info("ilustration_no :" + data.getIlustration_no() + ";");
            log.info("type_va :" + data.getType_va() + ";");
            log.info("va_number :" + data.getVa_number() + ";");
            log.info("++++++++++++++++++++++++++++");

            log.info("**** BEGIN INSERT ****");
            dailySubmissionService.insertDataSubmission(data);
            log.info("**** END INSERT ****");

            responseBody.setMessage("Successfull Insert Submission");
            responseBody.setResultCode("OK");
            responseBody.setErrorCode("");
            responseBody.setStatus("201");
            message = dataMapper.writeValueAsString(responseBody);

            return Response.status(Response.Status.OK).entity(message).type(MediaType.TEXT_PLAIN).build();
        } catch (RuntimeException e) {

            log.info("error : " + e.getMessage() + ",");
            if ("409".equals(e.getMessage())) {
                responseBody.setMessage("Error Send email Customer / Owner");
                responseBody.setErrorCode("409");
                responseBody.setStatus("409");
                responseBody.setResultCode("NOK");
                message = dataMapper.writeValueAsString(responseBody);
            } else if ("407".equals(e.getMessage())) {
                responseBody.setMessage("Upload File SPAJ A1 & A2 must be uploaded");
                responseBody.setErrorCode("407");
                responseBody.setStatus("407");
                responseBody.setResultCode("NOK");
                message = dataMapper.writeValueAsString(responseBody);
            } else if ("408".equals(e.getMessage())) {
                responseBody.setMessage("SPAJ No is Already Exist or SPAJ No is Not generated");
                responseBody.setErrorCode("408");
                responseBody.setStatus("408");
                responseBody.setResultCode("NOK");
                message = dataMapper.writeValueAsString(responseBody);
            } else if ("508".equals(e.getMessage())) {
                responseBody.setMessage("Error insert database Database");
                responseBody.setErrorCode("508");
                responseBody.setStatus("508");
                responseBody.setResultCode("NOK");
                message = dataMapper.writeValueAsString(responseBody);
            } else if ("509".equals(e.getMessage())) {
                responseBody.setMessage("Error Send SMS");
                responseBody.setErrorCode("509");
                responseBody.setStatus("509");
                responseBody.setResultCode("NOK");
                message = dataMapper.writeValueAsString(responseBody);
            } else if ("303".equals(e.getMessage())) {
                responseBody.setMessage("Error Data not Complete");
                responseBody.setErrorCode("303");
                responseBody.setStatus("303");
                responseBody.setResultCode("NOK");
                message = dataMapper.writeValueAsString(responseBody);
            } else if ("304".equals(e.getMessage())) {
                responseBody.setMessage("Data is Not found");
                responseBody.setErrorCode("304");
                responseBody.setStatus("304");
                responseBody.setResultCode("NOK");
                message = dataMapper.writeValueAsString(responseBody);
            } else if ("305".equals(e.getMessage())) {
                responseBody.setMessage("Branch Not Found");
                responseBody.setErrorCode("305");
                responseBody.setStatus("305");
                responseBody.setResultCode("NOK");
                message = dataMapper.writeValueAsString(responseBody);
            }

            return Response.status(Response.Status.BAD_REQUEST).entity(message).build();
        }

    }


}
