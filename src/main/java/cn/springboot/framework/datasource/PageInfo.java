package cn.springboot.framework.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 自定义分页对象，扩展 navigatepageNums
 *
 * @author 胡桃夹子
 * @date 2022-03-15 16:19
 */
public class PageInfo<T> extends Page<T> {

    /*
    https://github.com/pagehelper/Mybatis-PageHelper/blob/master/src/main/java/com/github/pagehelper/Page.java

    this.startRow = this.pageNum > 0 ? (this.pageNum - 1) * this.pageSize : 0;
    this.endRow = this.startRow + this.pageSize * (this.pageNum > 0 ? 1 : 0);
    */

    public long getPrePage() {
        if (this.getCurrent() > 1) {
            // 最后需要加1
            return this.getCurrent() - 1;
        }
        return 1;
    }

    public long getNextPage() {
        if (this.getCurrent() < this.getPages()) {
            // 最后需要加1
            return this.getCurrent() + 1;
        }
        return this.getPages();
    }

    public long getStartRow() {
        if (this.getCurrent() > 0) {
            // 最后需要加1
            return (this.getCurrent() - 1) * this.getSize() + 1;
        }
        return 0;
    }

    public long getEndRow() {
        long startRow = getStartRow();
        long endRow = startRow + this.getSize() * (this.getCurrent() > 0 ? 1 : 0);
        if (endRow > this.getTotal()) {
            endRow = this.getTotal();
        } else {
            endRow--;
        }
        return endRow;
    }

    public int[] getNavigatepageNums() {
        //当前的页码
        long current = this.getCurrent();
        //一共多少页
        long totalPage = this.getPages();
        //需要展示的页码个数
        int navSize = 8;

        //算出current左边有多少个
        int before = navSize / 2;

        //起始的页码，防止了起始为负数
        int start = current - before < 1 ? 1 : (int) (current - before);
        //终止的页码
        int end = start + navSize - 1;
        //如果终止页码大于等于总页码
        if (end >= totalPage) {
            //总页码就是终止页码
            end = (int) totalPage;
            //因为终止页码变动，起始页码也需要变动
            start = end - navSize + 1;
            //如果总页码小于展示页码个数的话，起始页码可能是负数，将它变为1
            if (start < 1) {
                start = 1;
            }
        }

        int[] navs = new int[totalPage < navSize ? (int) totalPage : navSize];
        for (int i = start, j = 0; i <= end; i++, j++) {
            navs[j] = i;
        }
        return navs;
    }

    public PageInfo(long current, long size) {
        super(current, size);
    }
}
