package lt.codeacademy.teamroom4.onlineshop.spring.security.jwt;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	@Value("${axios-post.app.jwtSecret}")
	private String jwtSecret;

	@Value("${axios-post.app.jwtExpirationMs}")
	private int jwtExpirationMs;

public String generateJwtToken(Authentication authentication) {
	UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
	return Jwts.Builder()
			.setSubject((userPrincipal.getUsername)))
	.setIssuedAt(new Date())
	.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
	.signWith(SignatureAlgorithm.HS512, jwtSecret)
	.compact();
	}
	public String getUserNameFromJwtToken(String token) {
	return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	public boolean validate JwtToken(String authToken) throws SignatureException{
	try {
		Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);;
		return true;
	} catch(MalformedJwtException e) {
		logger.error("Invald JWT token: {}", e.getMessage());
	} catch (ExpiredJwtException e) {
	logger.error("JWT token is expired: {}", e.getMessage());
	} catch (UnsupportedJwtException e) {
		logger.error("JWT token is unsupported:{}", e.getMessage());	
		} catch (IllegalArgumentException e) {
		logger.error("JWT claims string is empty: {}", e.getMessage());	
	}
	return false;
	
	}
}
