package com.fudges.server;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 王平远
 * @since 2022/8/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class test {

    public void test(){
        System.out.println("test1");
    }
}
