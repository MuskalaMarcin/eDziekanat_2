package edziekanat.listener;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filter selecting request and response encoding to ISO-8859-2.
 *
 * Created by Marcin on 09.04.2016.
 */
public class EncodingFilter implements Filter
{
    private String encoding;

    public void init(FilterConfig config) throws ServletException
    {
	encoding = config.getInitParameter("requestEncoding");

	if (encoding == null) encoding = "ISO-8859-2";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
		    throws IOException, ServletException
    {
	if (null == request.getCharacterEncoding())
	    request.setCharacterEncoding(encoding);

	response.setContentType("text/html; charset=ISO-8859-2");
	response.setCharacterEncoding("ISO-8859-2");

	next.doFilter(request, response);
    }

    public void destroy()
    {
    }
}
