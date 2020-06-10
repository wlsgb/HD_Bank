package dank.mvc.vo;

public class PageVO {
	
	// nowPage - 현재페이지
		// startPage - 시작페이지
		// endPage - 끝페이지
		// total - 게시글 총 갯수
		// cntPerPage - 페이지당 글 갯수, 마지막페이지
		// lastPage - 마지막페이지
		// start, end - 페이지 분할 값
		private int nowPage, startPage, endPage, total, cntPerPage, lastPage, start, end;
	//패이지 블록의 Cnt
		private int cntPage = 5;
		private String searchType,searchValue;
		private int categori;
		public int getCategori() {
			return categori;
		}

		public void setCategori(int categori) {
			this.categori = categori;
		}

		public String getSearchType() {
			return searchType;
		}

		public void setSearchType(String searchType) {
			this.searchType = searchType;
		}

		public String getSearchValue() {
			return searchValue;
		}

		public void setSearchValue(String searchValue) {
			this.searchValue = searchValue;
		}

		public PageVO() {
		}

		public PageVO(int total, int nowPage, int cntPerPage,int categori) {
			this.nowPage = nowPage;
			this.cntPerPage = cntPerPage;
			this.total = total;
			this.categori=categori;
			memberLastPage(total, cntPerPage);
			memberStartEndPage(nowPage, cntPage);
			memberStartEnd(nowPage, cntPerPage);
			System.out.println("카운트 :"+cntPage);
			System.out.println("종합 :"+total);
		}

		// 제일 마지막 페이지 계산
		private void memberLastPage(int total, int cntPerPage) {
			//1.1page 올림처리 -> 2페이지, 갯수 10당 -> 11개라면
			lastPage = (int) Math.ceil((double) total / (double) cntPerPage);
			
		}

		// 시작, 끝 페이지 계산
		private void memberStartEndPage(int nowPage, int cntPage) {
			endPage = ((int) Math.ceil((double) nowPage / (double) cntPage)) * cntPage;
			if(getCategori()==0)
			{
				if (getLastPage() < getEndPage()) {
					endPage = getLastPage();
				
				}
			}
			else {
				if (getLastPage() < getEndPage()) {
					endPage = getLastPage();
					System.out.println("마지막페이지수:" +endPage);
					System.out.println("라스트페이지수:" +lastPage);
				}
			}
			startPage = getEndPage() - cntPage + 1;
			if (getStartPage() < 1) {
				startPage = 1;
			}
		}

		private void memberStartEnd(int nowPage, int cntPerPage) {
			end = nowPage * cntPerPage;
			start = end - cntPerPage + 1;
		}

		public int getNowPage() {
			return nowPage;
		}

		public void setNowPage(int nowPage) {
			this.nowPage = nowPage;
		}

		public int getStartPage() {
			return startPage;
		}

		public void setStartPage(int startPage) {
			this.startPage = startPage;
		}

		public int getEndPage() {
			return endPage;
		}

		public void setEndPage(int endPage) {
			this.endPage = endPage;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public int getCntPerPage() {
			return cntPerPage;
		}

		public void setCntPerPage(int cntPerPage) {
			this.cntPerPage = cntPerPage;
		}

		public int getLastPage() {
			return lastPage;
		}

		public void setLastPage(int lastPage) {
			this.lastPage = lastPage;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int setCntPage() {
			return cntPage;
		}

		public void getCntPage(int cntPage) {
			this.cntPage = cntPage;
		}

		@Override
		public String toString() {
			return "PagingVO [nowPage=" + nowPage + ", startPage=" + startPage + ", endPage=" + endPage + ", total=" + total
					+ ", cntPerPage=" + cntPerPage + ", lastPage=" + lastPage + ", start=" + start + ", end=" + end
					+ ", cntPage=" + cntPage + "]";
		}

}
