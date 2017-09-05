package tz.co.nezatech.dev.bcrypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BcryptApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcryptApplication.class, args);
		BCryptPasswordEncoder passwordEncoder;
		String password = null;
		int size = 11;
		if (args.length >= 2) {
			password = args[0];
			size = Integer.parseInt(args[1]);
		} else if (args.length >= 1) {
			password = args[0];
		} else {
			System.out.println("Args size: " + args.length);
			System.err.println("Help\njava -jar bcrypt[-version].jar \"password\" [size]");
			System.exit(-1);
		}
		System.out.println("\n\n");
		passwordEncoder = new BCryptPasswordEncoder(size);
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println("Plain: " + password);
		System.out.println("Hashed: " + hashedPassword);
		System.out.println("\n\n");
	}
}
