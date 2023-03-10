package org.ecy.authjwt.security.reactive;

import java.util.Set;

public interface Credentials {

    String getUsername();
    String getPassword();
    Set<String> getRoles();

}
