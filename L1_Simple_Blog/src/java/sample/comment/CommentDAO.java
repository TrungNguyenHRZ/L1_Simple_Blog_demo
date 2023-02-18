/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.comment;

import java.io.Serializable;
import java.sql.Connection;
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
public class CommentDAO implements Serializable {

    private static final String GET_LIST_COMMENT = "SELECT titleId, email,comment FROM tblComment WHERE titleId = ? ORDER BY commentId DESC";
    private static final String COMMENT = "INSERT INTO tblComment(titleId, email, Comment)\n"
            + "VALUES(?,?,?)";

    public boolean comment(CommentDTO commentDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(COMMENT);
                ptm.setInt(1, commentDTO.getTitleId());
                ptm.setString(2, commentDTO.getEmail());
                ptm.setString(3, commentDTO.getComment());
                if(ptm.executeUpdate() > 0) {
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

    public List<CommentDTO> getListComment(int titleId) throws SQLException {
        List<CommentDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_COMMENT);
                ptm.setInt(1, titleId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    titleId = rs.getInt("titleId");
                    String email = rs.getString("email");
                    String comment = rs.getString("comment");
                    list.add(new CommentDTO(titleId, email, comment));
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
}
