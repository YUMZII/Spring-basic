package mybatis.dao;

import com.example.springlab.domain.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface StudentMapper1 {//Mapper에서 쿼리 실행
    @Select("select name, score from student")//쿼리 문자열 받고 실행
    public List<StudentDTO> listAll();
    @Select("select name, score from student order by score desc")
    public List<StudentDTO> listOrderByScoreDesc();
    @Select("select name, score from student where score >= 70")
    public List<StudentDTO> listByScoreGreaterEqualThan70();
    @Select("select name from student where name like concat('%' ,#{name},'%')")
    public List<StudentDTO> listByContainName(String name);
    @Select("select score from student where name = #{name}")
    public int getScore(String name);
    @Select("select avg(score) from student")
    public Double getScoreAvg();
}
