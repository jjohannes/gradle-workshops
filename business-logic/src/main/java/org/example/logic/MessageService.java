package org.example.logic;

import com.google.errorprone.annotations.Immutable;
import org.apache.commons.lang3.StringUtils;
import org.example.data.Message;

@Immutable
public class MessageService {

    public String doWork(Message m) {
        return StringUtils.capitalize("sbc");
    }
}
