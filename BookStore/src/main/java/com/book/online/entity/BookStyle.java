package com.book.online.entity;

import java.io.Serializable;

public class BookStyle implements Serializable{
    private static final long serialVersionUID = -5273982172521499356L;
    private Long bookStyleId;
    private String styleName;
    public BookStyle() {
        super();
    }
    public BookStyle(String styleName) {
        super();
        this.styleName = styleName;
    }
    public Long getBookStyleId() {
        return bookStyleId;
    }
    public void setBookStyleId(Long bookStyleId) {
        this.bookStyleId = bookStyleId;
    }
    public String getStyleName() {
        return styleName;
    }
    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bookStyleId == null) ? 0 : bookStyleId.hashCode());
        result = prime * result + ((styleName == null) ? 0 : styleName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BookStyle other = (BookStyle) obj;
        if (bookStyleId == null) {
            if (other.bookStyleId != null)
                return false;
        } else if (!bookStyleId.equals(other.bookStyleId))
            return false;
        if (styleName == null) {
            if (other.styleName != null)
                return false;
        } else if (!styleName.equals(other.styleName))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "BookStyle [bookStyleId=" + bookStyleId + ", styleName=" + styleName + "]";
    }
}
