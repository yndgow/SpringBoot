package kr.co.farmstory.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageVO {

    private int totalPage;
    private int startNumber;
    private int endNumber;
    private boolean hasPrev;
    private boolean hasNext;
    private int prevIndex;
    private int nextIndex;
    private long totalCount;
}
