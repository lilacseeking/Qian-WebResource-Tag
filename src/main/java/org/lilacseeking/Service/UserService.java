package org.lilacseeking.Service;

import org.lilacseeking.Utils.Page;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public Page listAllUser(Page page);
}
