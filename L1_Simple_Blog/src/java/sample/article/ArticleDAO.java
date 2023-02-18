/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.article;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author MY PC
 */
public class ArticleDAO implements Serializable {

    private static final String SEARCH = "SELECT titleId,titleName,shortDescription,content,author,date,status\n"
            + "FROM tblArticle WHERE content like ? AND status like 'Active' ORDER BY date DESC";
    private static final String GET_DETAIL = "SELECT titleId,titleName,shortDescription,content,author,date,status\n"
            + "FROM tblArticle WHERE titleName like ? ORDER BY date DESC";
    private static final String INSERT = "INSERT INTO tblArticle(titleName, shortDescription,content,author,date,status)\n"
            + "VALUES(?,?,?,?,?,?)";
    private static final String GET_ALL_ARTICAL = "SELECT titleId,titleName,shortDescription,content,author,date,status FROM tblArticle ORDER BY date DESC\n";
    private static final String UPDATE = "UPDATE tblArticle SET status = 'Active' WHERE titleId = ?";
    private static final String DELETE = "UPDATE tblArticle SET status = 'Deleted' WHERE titleId = ?";

     public boolean deleteArticle(String status) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, status);
                if (ptm.executeUpdate() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }
     
    public boolean updateArticle(String status) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, status);
                if (ptm.executeUpdate() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public List<ArticleDTO> getAllArticle() throws SQLException {
        List<ArticleDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL_ARTICAL);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int titleId = rs.getInt("titleId");
                    String titleName = rs.getString("titleName");
                    String shortDescription = rs.getString("shortDescription");
                    String content = rs.getString("content");
                    String author = rs.getString("author");
                    String date = rs.getString("date");
                    String status = rs.getString("status");
                    list.add(new ArticleDTO(titleId, titleName, shortDescription, content, author, date, status));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ArticleDTO> getListArticle(String content) throws SQLException {
        List<ArticleDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + content + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int titleId = rs.getInt("titleId");
                    String titleName = rs.getString("titleName");
                    String shortDescription = rs.getString("shortDescription");
                    content = rs.getString("content");
                    String author = rs.getString("author");
                    String date = rs.getString("date");
                    String status = rs.getString("status");
                    list.add(new ArticleDTO(titleId, titleName, shortDescription, content, author, date, status));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public ArticleDTO getArticleDetail(String titleName) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ArticleDTO articleDTO = new ArticleDTO();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_DETAIL);
                ptm.setString(1, titleName);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int titleId = rs.getInt("titleId");
                    titleName = rs.getString("titleName");
                    String shortDescription = rs.getString("shortDescription");
                    String content = rs.getString("content");
                    String author = rs.getString("author");
                    String date = rs.getString("date");
                    String status = rs.getString("status");
                    articleDTO = new ArticleDTO(titleId, titleName, shortDescription, content, author, date, status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return articleDTO;
    }

    public boolean insertArticle(ArticleDTO articleDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, articleDTO.getTitleName());
                ptm.setString(2, articleDTO.getShortDescription());
                ptm.setString(3, articleDTO.getContent());
                ptm.setString(4, articleDTO.getAuthor());
                Long milis = System.currentTimeMillis();
                Date date = new Date(milis);
                ptm.setString(5, date.toString());
                ptm.setString(6, articleDTO.getStatus());
                if (ptm.executeUpdate() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ptm != null) {
                ptm.close();
            }
        }
        return false;
    }
}
