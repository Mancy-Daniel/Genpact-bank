package com.bank.servlet;

import com.bank.dao.CustomerDAO;
import com.bank.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/viewCustomer")
public class ViewCustomerServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;

    @Override
    public void init() throws ServletException {
        customerDAO = new CustomerDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerIdParam = request.getParameter("customerId");
        if (customerIdParam != null && !customerIdParam.isEmpty()) {
            int customerId = Integer.parseInt(customerIdParam);
            try {
                Customer customer = customerDAO.getCustomerById(customerId);
                if (customer != null) {
                    request.setAttribute("customer", customer);
                    request.getRequestDispatcher("view-customer.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Customer not found.");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving customer details.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid customer ID.");
        }
    }
}
