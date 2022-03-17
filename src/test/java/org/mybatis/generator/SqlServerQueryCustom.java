package org.mybatis.generator;

import com.baomidou.mybatisplus.generator.config.querys.SqlServerQuery;
import org.apache.commons.lang3.StringUtils;


public class SqlServerQueryCustom extends SqlServerQuery {
    private String schema = "";
    private String prefix = "";

    public SqlServerQueryCustom(String schema, String prefix) {
        this.schema = schema;
        this.prefix = prefix;
    }

    @Override
    public String tablesSql() {
        if (schema.length() > 0) {
            return "select TABLE_NAME,COMMENTS\n" +
                    "from (select schema_name(so.uid) as schemaName, so.*,cast(so.name as varchar(500)) as TABLE_NAME, cast(sep.value as varchar(500)) as COMMENTS\n" +
                    "      from sysobjects so\n" +
                    "               left JOIN sys.extended_properties sep on sep.major_id = so.id and sep.minor_id = 0\n" +
                    "      where (xtype = 'U') ) a\n" +
                    "where 1 = 1\n" +
                    "and schemaName='" + schema + "'" + (!StringUtils.isBlank(prefix) ? " and TABLE_NAME like '%" + prefix + "%'" : "");
        } else {
            return "select * from (select cast(so.name as varchar(500)) as TABLE_NAME, " +
                    "cast(sep.value as varchar(500)) as COMMENTS from sysobjects so " +
                    "left JOIN sys.extended_properties sep on sep.major_id=so.id and sep.minor_id=0 " +
                    "where (xtype='U')) a where 1=1 ";
        }

    }

    @Override
    public String tableFieldsSql() {
        if (schema.length() == 0) {
            return "SELECT  cast(a.name AS VARCHAR(500)) AS TABLE_NAME,cast(b.name AS VARCHAR(500)) AS COLUMN_NAME, "
                    + "cast(c.VALUE AS NVARCHAR(500)) AS COMMENTS,cast(sys.types.name AS VARCHAR (500)) AS DATA_TYPE,"
                    + "(" + " SELECT CASE count(1) WHEN 1 then 'PRI' ELSE '' END"
                    + " FROM syscolumns,sysobjects,sysindexes,sysindexkeys,systypes "
                    + " WHERE syscolumns.xusertype = systypes.xusertype AND syscolumns.id = object_id (a.name) AND sysobjects.xtype = 'PK'"
                    + " AND sysobjects.parent_obj = syscolumns.id " + " AND sysindexes.id = syscolumns.id "
                    + " AND sysobjects.name = sysindexes.name AND sysindexkeys.id = syscolumns.id "
                    + " AND sysindexkeys.indid = sysindexes.indid "
                    + " AND syscolumns.colid = sysindexkeys.colid AND syscolumns.name = b.name) as 'KEY',"
                    + "  b.is_identity isIdentity "
                    + " FROM ( select name,object_id from sys.tables UNION all select name,object_id from sys.views ) a "
                    + " INNER JOIN sys.columns b ON b.object_id = a.object_id "
                    + " LEFT JOIN sys.types ON b.user_type_id = sys.types.user_type_id   "
                    + " LEFT JOIN sys.extended_properties c ON c.major_id = b.object_id AND c.minor_id = b.column_id "
                    + " WHERE a.name = '%s' and sys.types.name !='sysname' ";
        } else {
            return "SELECT  cast(a.name AS VARCHAR(500)) AS TABLE_NAME,cast(b.name AS VARCHAR(500)) AS COLUMN_NAME, "
                    + "cast(c.VALUE AS NVARCHAR(500)) AS COMMENTS,cast(sys.types.name AS VARCHAR (500)) AS DATA_TYPE,"
                    + "(" + " SELECT CASE count(1) WHEN 1 then 'PRI' ELSE '' END"
                    + " FROM syscolumns,sysobjects,sysindexes,sysindexkeys,systypes "
                    + " WHERE syscolumns.xusertype = systypes.xusertype AND syscolumns.id = object_id ('" + schema + "' + '.' + a.name) AND sysobjects.xtype = 'PK'"
                    + " AND sysobjects.parent_obj = syscolumns.id " + " AND sysindexes.id = syscolumns.id "
                    + " AND sysobjects.name = sysindexes.name AND sysindexkeys.id = syscolumns.id "
                    + " AND sysindexkeys.indid = sysindexes.indid "
                    + " AND syscolumns.colid = sysindexkeys.colid AND syscolumns.name = b.name) as 'KEY',"
                    + "  b.is_identity isIdentity "
                    + " FROM ( select name,object_id from sys.tables UNION all select name,object_id from sys.views ) a "
                    + " INNER JOIN sys.columns b ON b.object_id = a.object_id "
                    + " LEFT JOIN sys.types ON b.user_type_id = sys.types.user_type_id   "
                    + " LEFT JOIN sys.extended_properties c ON c.major_id = b.object_id AND c.minor_id = b.column_id "
                    + " WHERE a.name = '%s' and sys.types.name !='sysname' ";
        }

    }
}
