package org.zerock.ex1.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.ex1.dto.GuestbookDTO;
import org.zerock.ex1.dto.PageRequestDTO;
import org.zerock.ex1.dto.PageResultDTO;
import org.zerock.ex1.entity.Guestbook;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestbookServiceTest {

    @Autowired
    private GuestbookService service;

    @Test
    public void testRegister(){
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title...")
                .content("Sample Content...")
                .writer("user0")
                .build();

        System.out.println(service.register(guestbookDTO));
    }

    @Test
    public void testList() throws Exception {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("PREV: " + resultDTO.isPrev());
        System.out.println("NEXT: " + resultDTO.isNext());
        System.out.println("TOTAL: " + resultDTO.getTotalPage());
        System.out.println("========================");

        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()){
            System.out.println(guestbookDTO);
        }

        System.out.println("========================");
        resultDTO.getPageList().forEach(i -> System.out.println(i));

    }

}