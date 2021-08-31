package com.moodle.integration.commons.interceptor;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {

    HttpServletResponse response = (HttpServletResponse) res;
    response.setHeader("X-XSS-Protection", "1; mode=block");
    response.setHeader("X-Frame-Options", "deny");
    response.setHeader("X-Content-Type-Options", "nosniff");
    response.setHeader("Strict-Transport-Security", "max-age=31622400; includeSubDomains");
    response.setHeader("X-Content-Security-Policy", "default-src 'self'");
    response.setHeader("X-Permitted-Cross-Domain-Policies", "none");
    response.setHeader("Expect-CT", "max-age=31536000, enforce");
    response.setHeader("Referrer-Policy", "same-origin");
    response.setHeader("Cache-Control", "no-cache, no-store");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "-1");
    chain.doFilter(req, res);
  }

  @Override
  public void init(FilterConfig filterConfig) {}

  @Override
  public void destroy() {}
}
