package kr.bespinlab.nivea.parameter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
public class MySqlPageNavParam {

    private int currentPage;
    private int contentsPerPage;
    private int PAGES_PER_BLOCK;
    private int totalContents;

    private int totalPages;
    private int startPage;
    private int endPage;
    private boolean prevActive;
    private boolean nextActive;

    public MySqlPageNavParam(int currentPage, int contentsPerPage, int totalContents) {
        this.currentPage = currentPage;
        this.contentsPerPage = contentsPerPage;
        this.PAGES_PER_BLOCK = 5;
        this.totalContents = totalContents;

        totalPages = calculateTotalPages(totalContents, contentsPerPage);

        startPage = ( ( (currentPage-1) / PAGES_PER_BLOCK) * PAGES_PER_BLOCK) + 1;
        endPage = startPage + PAGES_PER_BLOCK - 1;
        if (endPage > totalPages) {
            endPage = totalPages;
        }

        prevActive = (startPage == 1) ? false : true;
        nextActive = (endPage < totalPages) ? true : false;
    }

    private int calculateTotalPages(int totalContents, int contentsPerPage) {
        int totalPages = totalContents/contentsPerPage;
        if (totalContents%contentsPerPage > 0) {
            totalPages++;
        }
        return totalPages;
    }
}
