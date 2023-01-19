package kr.co.sboard.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FileVO {
	private int fno;
	private int parent;
	private String newName;
	private String oriName;
	private int download;
	private LocalDateTime rdate;
}
