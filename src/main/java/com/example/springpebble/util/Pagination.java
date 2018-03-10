package com.example.springpebble.util;

import lombok.Data;

/**
 * Created by yookeun on 2018. 3. 9..
 */
@Data
public class Pagination {
    private int pageNo=1;        			// 현재 페이지 번호
    private int pageSize=3;    		        // 페이지당 레코드 수
    private int firstPageNo = 1;          	// 첫번째 페이지 번호
    private int startPageNo = 1;            // 구간 시작 페이지
    private int prevPageNo;           		// 이전 페이지 번호(페이징 너비 기준)
    private int nextPageNo;           		// 다음 페이지 번호(페이징 너비 기준)
    private int finalPageNo;          		// 마지막 페이지 번호
    private int totalCount;    			    // 전체 레코드 수
    private int sizeOfPage = 3;             // 보여지는 페이지 갯수 (1,2,3 갯수)
    private int sizeOfPageEnd;              //보여지는 페이지 갯수에 해당되는 마지막 페이지번호
    private int start = 0;                   // sql에서 시작값 LIMIT ${countFromZero}, ${pageSize}
    private int countFromMax;               //페이지 내의 가장 큰 수

    public void makePagination() {
        //마지막 페이지 구하기
        if (totalCount % pageSize == 0) {
            finalPageNo = totalCount / pageSize;
        } else {
            finalPageNo = (totalCount / pageSize) + 1;
        }

        //현재페이지가 마지막 페이지보다는 클수 없다.
        if (pageNo > finalPageNo) {
            return;
        }

        //시작페이지 구하기 = ( (페이지 번호 -1) / 총 페이지 사이즈 ) * 총 페이지 사이즈 + 1
        startPageNo = ( (pageNo -1) / sizeOfPage ) * sizeOfPage + 1;

        //구간에서 다음페이지( > ) 값 구하기
        nextPageNo = startPageNo + sizeOfPage;

        //마지막 페이지에서 구간 사이즈 구하기
        if ( (finalPageNo - startPageNo) < sizeOfPage ) {
            sizeOfPage = finalPageNo - startPageNo + 1;
        }

        // sql 조회 시작 값
        start = (pageSize * pageNo) - (pageSize);
        countFromMax = totalCount - (pageSize * (pageNo - 1));
    }
}
