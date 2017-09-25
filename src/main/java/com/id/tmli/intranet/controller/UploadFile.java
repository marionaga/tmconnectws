package com.id.tmli.intranet.controller;

import com.id.tmli.intranet.common.ResponseBody;
import com.id.tmli.intranet.model.form.UpdateFileAmendment;
import com.id.tmli.intranet.service.impl.UploadServiceImpl;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

/**
 * Created by hito.mario on 06/02/2017.
 */
@Path("/update")
public class UploadFile {

    final static Logger log = Logger.getLogger(UploadFile.class);

    @POST
    @Path("/amendment")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response uploadAmanmendData(@Valid UpdateFileAmendment data) throws IOException, RuntimeException {

        Response response;
        String message = "";
        ObjectMapper dataMapper = new ObjectMapper();
        ResponseBody responseBody = new ResponseBody();
        UploadServiceImpl uploadServiceImpl = new UploadServiceImpl();

        try {

            uploadServiceImpl.uploadAmanmendFile(data);

            responseBody.setMessage("Successfull Insert File SPAJ");
            responseBody.setResultCode("OK");
            responseBody.setErrorCode("");
            responseBody.setStatus("201");
            message = dataMapper.writeValueAsString(responseBody);

            log.info("**** END INSERT ****");
            return Response.status(Response.Status.OK).entity(message).type(MediaType.TEXT_PLAIN).build();

        } catch (RuntimeException e) {
            e.printStackTrace();

            log.info("error : " + e.getMessage() + ",");
            if ("304".equals(e.getMessage())) {
                responseBody.setMessage("Data is Not found");
                responseBody.setErrorCode("304");
                responseBody.setStatus("304");
                responseBody.setResultCode("NOK");
                message = dataMapper.writeValueAsString(responseBody);
            } else if ("508".equals(e.getMessage())) {
                responseBody.setMessage("Error insert database Database");
                responseBody.setErrorCode("508");
                responseBody.setStatus("508");
                responseBody.setResultCode("NOK");
                message = dataMapper.writeValueAsString(responseBody);
            } else if ("404".equals(e.getMessage())) {
                responseBody.setMessage("The Process cannot access the file because it is being used by another process or File Not found");
                responseBody.setErrorCode("404");
                responseBody.setStatus("404");
                responseBody.setResultCode("NOK");
                message = dataMapper.writeValueAsString(responseBody);
            } else if ("303".equals(e.getMessage())) {
                responseBody.setMessage("Error Data not Complete");
                responseBody.setErrorCode("303");
                responseBody.setStatus("303");
                responseBody.setResultCode("NOK");
                message = dataMapper.writeValueAsString(responseBody);
            }

            return Response.status(Response.Status.BAD_REQUEST).entity(message).build();
        }
    }

}