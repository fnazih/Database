package beanstateless;

import javax.ejb.Remote;

@Remote
public interface IBeanStateless {
    String salut(String name);
}
