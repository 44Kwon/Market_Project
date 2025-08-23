package com.gamemarket.response;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

//데이터 반환 DTO
public class ResponseDto {

    //단일 객체 반환
    @AllArgsConstructor
    public static class SingleResponseDto<T> {
        private T data;
    }

    //여러 객체 반환
    public static class MultipleResponseDto<T> {
        private List<T> data;
        private PageInfo pageInfo;

        public MultipleResponseDto(List<T> data, Page page) {
            this.data = data;
            //클라이언트에는 1페이지 부터 보여줘야하므로 +1을 해준다.
            this.pageInfo = new PageInfo(page.getNumber()+1, page.getSize(), page.getTotalElements(), page.getTotalPages());
        }
    }
}
