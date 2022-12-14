package in.com.rays.ORSprojectt4.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.rays.ORSprojectt4.bean.MarksheetBean;
import in.com.rays.ORSprojectt4.exception.ApplicationException;
import in.com.rays.ORSprojectt4.model.MarksheetModel;
import in.com.rays.ORSprojectt4.utility.DataUtility;
import in.com.rays.ORSprojectt4.utility.DataValidator;
import in.com.rays.ORSprojectt4.utility.PropertyReader;
import in.com.rays.ORSprojectt4.utility.ServletUtility;

/**
 * @author yashita
 *
 */
@WebServlet("/ctl/GetMarksheetCtl")
public class GetMarksheetCtl extends BaseCtl {
//	private static Logger log = Logger.getLogger(GetMarksheetCtl.class);

    @Override
    protected boolean validate(HttpServletRequest request) {

    	
     //   log.debug("GetMarksheetCTL Method validate Started");

        boolean pass = true;

        if (DataValidator.isNull(request.getParameter("rollNo"))) {
            request.setAttribute("rollNo",
                    PropertyReader.getValue("error.require", "Roll Number"));
            pass = false;
        }else  if (!DataValidator.isRollNo(request.getParameter("rollNo"))) {
            request.setAttribute("rollNo",
                    "Roll Number must be in alphanumeric format {00AA0000} ");
            pass = false;
        }

      //  log.debug("GetMarksheetCTL Method validate Ended");

        return pass;
    }

    @Override
    protected MarksheetBean populateBean(HttpServletRequest request) {

      //  log.debug("GetMarksheetCtl Method populatebean Started");

        MarksheetBean bean = new MarksheetBean();

        bean.setId(DataUtility.getInt(request.getParameter("id")));

        bean.setRollNo(DataUtility.getString(request.getParameter("rollNo")));

        //bean.setName(DataUtility.getString(request.getParameter("name")));

//        bean.setPhysics(DataUtility.getInt(request.getParameter("physics")));

  //      bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));

        bean.setMaths(DataUtility.getInt(request.getParameter("maths")));

        //log.debug("GetMarksheetCtl Method populatebean Ended");

        return bean;
    }

    /**
     * Concept of Display method
     *
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ServletUtility.forward(getView(), request, response);
    }

    /**
     * Concept of Submit Method
     *
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

      //  log.debug("GetMarksheetCtl Method doGet Started");
        String op = DataUtility.getString(request.getParameter("operation"));

        // get model
        MarksheetModel model = new MarksheetModel();

        MarksheetBean bean = populateBean(request);


        if (OP_GO.equalsIgnoreCase(op)) {

            try {
                bean = model.findByRollNo(bean.getRollNo());	
                if (bean != null) {
                    ServletUtility.setBean(bean, request);
                } else {
                    ServletUtility.setErrorMessage("Given Roll No. Does Not Exist",
                            request);
                }
            } catch (ApplicationException e) {
            //    log.error(e);
                ServletUtility.handleException(e, request, response);
                return;
            }

        }else if (OP_RESET.equalsIgnoreCase(op)) {
        	ServletUtility.redirect(ORSView.GET_MARKSHEET_CTL, request, response);
        	return;
        }
        ServletUtility.forward(getView(), request, response);
       // log.debug("MarksheetCtl Method doGet Ended");
    }

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.GET_MARKSHEET_VIEW;
	}

}
