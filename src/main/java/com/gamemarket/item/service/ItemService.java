package com.gamemarket.item.service;

import com.gamemarket.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    //관리자 전용 아이템 등록


    //아이템 조회(전체, 카테고리별)
    //전체 조회


    //아이템 단건 조회

    //아이템 수정(관리자)

    //아이템 삭제(관리자)
}
