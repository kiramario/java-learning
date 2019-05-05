USE [hxo2o]
IF  EXISTS (SELECT 1 FROM dbo.sysobjects where name='v_tb_colinfo' and xtype='V')
DROP VIEW [dbo].[v_tb_colinfo]

GO

/****** Object:  View [dbo].[v_tb_colinfo]    Script Date: 07/06/2017 16:54:43 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE VIEW [dbo].[v_tb_colinfo]
as 

select	tb_a_col.id as sysobj_id, tb_a_col.table_name, tb_a_col.colname,tb_a_col.xtype,tb_a_col.colid,
		case 
			when exists (
				select 1 
				FROM dbo.sysindexes si
				INNER JOIN dbo.sysindexkeys sik ON si.id = sik.id
				AND si.indid = sik.indid
				INNER JOIN dbo.syscolumns sc ON sc.id = sik.id
				AND sc.colid = sik.colid
				INNER JOIN dbo.sysobjects so ON so.name = si.name
				AND so.xtype = 'PK'
				WHERE tb_a_col.colid=sc.colid
				AND tb_a_col.id=sc.id
			)	then '1'
			else ''
		end as is_pk
from(
	select tb.name as table_name,col.name as colname,col.xtype, col.colid, col.id
	from(
		select id,name 
		from dbo.sysobjects 
		where xtype= 'U'
		AND status >= 0
	)tb
	left join dbo.syscolumns col on tb.id=col.id
)tb_a_col

GO

