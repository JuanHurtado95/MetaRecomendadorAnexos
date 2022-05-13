EXEC sys.sp_db_vardecimal_storage_format N'recomendadordb', N'ON'
GO
ALTER DATABASE [recomendadordb] SET QUERY_STORE = OFF
GO
USE [recomendadordb]
GO
/****** Object:  Table [dbo].[busqueda]    Script Date: 21/04/2022 11:05:39 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[busqueda](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_usuario] [int] NULL,
	[palabra_buscada] [varchar](200) NOT NULL,
	[categoria] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[flyway_schema_history]    Script Date: 21/04/2022 11:05:39 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[flyway_schema_history](
	[installed_rank] [int] NOT NULL,
	[version] [nvarchar](50) NULL,
	[description] [nvarchar](200) NULL,
	[type] [nvarchar](20) NOT NULL,
	[script] [nvarchar](1000) NOT NULL,
	[checksum] [int] NULL,
	[installed_by] [nvarchar](100) NOT NULL,
	[installed_on] [datetime] NOT NULL,
	[execution_time] [int] NOT NULL,
	[success] [bit] NOT NULL,
 CONSTRAINT [flyway_schema_history_pk] PRIMARY KEY CLUSTERED 
(
	[installed_rank] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[recomendacion]    Script Date: 21/04/2022 11:05:39 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[recomendacion](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_usuario] [int] NOT NULL,
	[primera_recomendacion] [varchar](45) NULL,
	[seguda_recomendacion] [varchar](45) NULL,
	[tercera_recomendacion] [varchar](45) NULL,
	[cuarta_recomendacion] [varchar](45) NULL,
	[fecha_creacion] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[usuario]    Script Date: 21/04/2022 11:05:39 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[usuario](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
	[clave] [varchar](45) NOT NULL,
	[correo] [varchar](45) NOT NULL,
	[genero] [varchar](45) NOT NULL,
	[edad] [int] NOT NULL,
	[fecha_creacion] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
CREATE NONCLUSTERED INDEX [flyway_schema_history_s_idx] ON [dbo].[flyway_schema_history]
(
	[success] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[feedback] ADD  DEFAULT ((1)) FOR [disponible]
GO
ALTER TABLE [dbo].[flyway_schema_history] ADD  DEFAULT (getdate()) FOR [installed_on]
GO
/****** Object:  StoredProcedure [dbo].[sp_recomendacion]    Script Date: 21/04/2022 11:05:39 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Juan Carlos Hurtado>
-- Create date:	<21/122/2021>
-- Description:	<Procedimiento que realiza las consultas filtradas para las recomendaciones a usuarios>
-- =============================================
USE [recomendadordb]
GO

/****** Object:  StoredProcedure [dbo].[sp_recomendacion]    Script Date: 13/05/2022 2:49:38 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Juan Carlos Hurtado>
-- Create date:	<21/122/2021>
-- Description:	<Procedimiento que realiza las consultas filtradas para las recomendaciones a usuarios>
-- =============================================
CREATE PROCEDURE [dbo].[sp_recomendacion]
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	DECLARE @numero_registros INT
	DECLARE @contador int = 1

	SET @numero_registros = (SELECT COUNT(*) FROM recomendacion) + 1

	select @numero_registros
	select @contador

	

	INSERT INTO [dbo].[recomendacion]
           ([id_usuario])
		   
	 SELECT (u.id)
	 --select *
	 FROM recomendadordb.dbo.usuario as u
	 WHERE NOT EXISTS (SELECT *
						FROM recomendadordb.dbo.recomendacion as r
						where r.id_usuario = u.id)

	WAITFOR DELAY '00:00:01'

	 WHILE(@numero_registros > @contador)
	 BEGIN
		if (select count(*) from recomendadordb.dbo.busqueda as b where id_usuario=(SELECT @contador)) = 0
		begin
			UPDATE rec
			SET rec.primera_recomendacion = (SELECT TOP 1 palabra_buscada
											FROM recomendadordb.dbo.usuario 
											inner join busqueda as b on usuario.id = b.id_usuario
											WHERE genero = 'femenino')
			FROM recomendadordb.dbo.recomendacion as rec
			inner join recomendadordb.dbo.usuario as u on u.id = rec.id_usuario
			where rec.id_usuario = (SELECT @contador)
			and u.genero='femenino'

			UPDATE rec
			SET rec.seguda_recomendacion = (SELECT TOP 1 palabra_buscada
										FROM recomendadordb.dbo.usuario 
										inner join busqueda as b on usuario.id = b.id_usuario
										WHERE genero = 'femenino'
										and palabra_buscada <> (select primera_recomendacion 
																from recomendadordb.dbo.recomendacion
																where id_usuario = (SELECT @contador)))
			FROM recomendadordb.dbo.recomendacion as rec
			inner join recomendadordb.dbo.usuario as u on u.id = rec.id_usuario
			where rec.id_usuario = (SELECT @contador)
			and u.genero='femenino'

			UPDATE rec
			SET	rec.tercera_recomendacion = (SELECT TOP 1 palabra_buscada
											FROM recomendadordb.dbo.usuario 
											inner join busqueda as b on usuario.id = b.id_usuario
											WHERE genero = 'femenino'
											and palabra_buscada <> (select primera_recomendacion 
																	from recomendadordb.dbo.recomendacion
																	where id_usuario = (SELECT @contador))
											and palabra_buscada <> (select seguda_recomendacion 
																	from recomendadordb.dbo.recomendacion
																	where id_usuario = (SELECT @contador)))
			FROM recomendadordb.dbo.recomendacion as rec
			inner join recomendadordb.dbo.usuario as u on u.id = rec.id_usuario
			where rec.id_usuario = (SELECT @contador)
			and u.genero='femenino';

			UPDATE rec
			SET	rec.cuarta_recomendacion = (SELECT TOP 1 palabra_buscada
											FROM recomendadordb.dbo.usuario 
											inner join busqueda on usuario.id = busqueda.id_usuario
											WHERE genero = 'femenino'
											and palabra_buscada <> (select primera_recomendacion 
																	from recomendadordb.dbo.recomendacion
																	where id_usuario = (SELECT @contador))
											and palabra_buscada <> (select seguda_recomendacion 
																	from recomendadordb.dbo.recomendacion
																	where id_usuario = (SELECT @contador))
											and palabra_buscada <> (select tercera_recomendacion 
																	from recomendadordb.dbo.recomendacion
																	where id_usuario = (SELECT @contador)))  
			--select rec.*
			FROM recomendadordb.dbo.recomendacion as rec
			inner join recomendadordb.dbo.usuario as u on u.id = rec.id_usuario
			where rec.id_usuario = (SELECT @contador)
				and u.genero='femenino';


			UPDATE rec
			SET rec.primera_recomendacion = (SELECT TOP 1 palabra_buscada
											FROM recomendadordb.dbo.usuario 
											inner join busqueda as b on usuario.id = b.id_usuario
											WHERE genero = 'masculino')
			FROM recomendadordb.dbo.recomendacion as rec
			inner join recomendadordb.dbo.usuario as u on u.id = rec.id_usuario
			where rec.id_usuario = (SELECT @contador)
			and u.genero='masculino'

			UPDATE rec
			SET	rec.seguda_recomendacion = (SELECT TOP 1 palabra_buscada
											FROM recomendadordb.dbo.usuario 
											inner join busqueda as b on usuario.id = b.id_usuario
											WHERE genero = 'masculino'
											and palabra_buscada <> (select primera_recomendacion 
																	from recomendadordb.dbo.recomendacion
																	where id_usuario = (SELECT @contador)))
			FROM recomendadordb.dbo.recomendacion as rec
			inner join recomendadordb.dbo.usuario as u on u.id = rec.id_usuario
			where rec.id_usuario = (SELECT @contador)
			and u.genero='masculino';

			UPDATE rec
			SET	rec.tercera_recomendacion = (SELECT TOP 1 palabra_buscada
											FROM recomendadordb.dbo.usuario 
											inner join busqueda as b on usuario.id = b.id_usuario
											WHERE genero = 'masculino'
											and palabra_buscada <> (select primera_recomendacion 
																	from recomendadordb.dbo.recomendacion
																	where id_usuario = (SELECT @contador))
											and palabra_buscada <> (select seguda_recomendacion 
																	from recomendadordb.dbo.recomendacion
																	where id_usuario = (SELECT @contador)))
			FROM recomendadordb.dbo.recomendacion as rec
			inner join recomendadordb.dbo.usuario as u on u.id = rec.id_usuario
			where rec.id_usuario = (SELECT @contador)
			and u.genero='masculino';

			UPDATE rec
			SET	rec.cuarta_recomendacion = (SELECT TOP 1 palabra_buscada
											FROM recomendadordb.dbo.usuario 
											inner join busqueda on usuario.id = busqueda.id_usuario
											WHERE genero = 'masculino'
											and palabra_buscada <> (select primera_recomendacion 
																	from recomendadordb.dbo.recomendacion
																	where id_usuario = (SELECT @contador))
											and palabra_buscada <> (select seguda_recomendacion 
																	from recomendadordb.dbo.recomendacion
																	where id_usuario = (SELECT @contador))
											and palabra_buscada <> (select tercera_recomendacion 
																	from recomendadordb.dbo.recomendacion
																	where id_usuario = (SELECT @contador)))
			--select rec.*
			FROM recomendadordb.dbo.recomendacion as rec
			inner join recomendadordb.dbo.usuario as u on u.id = rec.id_usuario
			where rec.id_usuario = (SELECT @contador)
			and u.genero='masculino';

		end
		else
		begin
	

			--*************************** PRIMERA RECOMENDACION
				UPDATE rec
				SET rec.primera_recomendacion = (SELECT TOP 1 palabra_buscada--, COUNT(*) as cantidad 
												 FROM recomendadordb.dbo.busqueda as b
												 where b.id_usuario = (SELECT @contador)
												 GROUP BY palabra_buscada
												 HAVING COUNT(*)>1
												 ORDER BY COUNT(*) DESC)
				--select rec.*
				FROM recomendadordb.dbo.recomendacion as rec
				where rec.id_usuario = @contador;

				--*************************** SEGUNDA RECOMENDACION

				UPDATE rec
				SET rec.seguda_recomendacion = (SELECT TOP 1 palabra_buscada
												FROM recomendadordb.dbo.busqueda as b
												where b.id_usuario in (select DISTINCT id_usuario
																		from busqueda as b
																		where palabra_buscada = (select primera_recomendacion
																									from recomendacion r
																									where r.id_usuario = (SELECT @contador)))
												AND palabra_buscada <> (select primera_recomendacion
																		from recomendadordb.dbo.recomendacion r
																		where r.id_usuario = (SELECT @contador)) 											
												GROUP BY palabra_buscada
												HAVING COUNT(*)>1
												ORDER BY COUNT(*) DESC)
				--select rec.*
				FROM recomendadordb.dbo.recomendacion as rec
				where rec.id_usuario = @contador;
		
				--*************************** TERCERA RECOMENDACION

				UPDATE rec
				SET rec.tercera_recomendacion = (SELECT TOP 1 palabra_buscada
												  -- select palabra_buscada, COUNT(*)
												  FROM recomendadordb.dbo.usuario
												  inner join busqueda on usuario.id = id_usuario
												  WHERE palabra_buscada <> (select primera_recomendacion
										  								from recomendadordb.dbo.recomendacion r
										  								where r.id_usuario = (SELECT @contador))
												  and palabra_buscada <> (select seguda_recomendacion
										  								from recomendadordb.dbo.recomendacion r
										  								where r.id_usuario = (SELECT @contador))
												  and edad BETWEEN 15 and 20
												  GROUP BY palabra_buscada
												  HAVING COUNT(*)>1
												  ORDER BY COUNT(*) DESC)
				--select rec.*
				FROM recomendadordb.dbo.recomendacion as rec
				inner join usuario as u on u.id = rec.id_usuario
				WHERE u.id = (SELECT @contador)
				and edad BETWEEN 15 and 20;

				UPDATE rec
				SET rec.tercera_recomendacion = (SELECT TOP 1 palabra_buscada
												  -- select palabra_buscada, COUNT(*)
												  FROM recomendadordb.dbo.usuario
												  inner join busqueda on usuario.id = id_usuario
												  WHERE palabra_buscada <> (select primera_recomendacion
										  								from recomendadordb.dbo.recomendacion r
										  								where r.id_usuario = (SELECT @contador))
												  and palabra_buscada <> (select seguda_recomendacion
										  								from recomendadordb.dbo.recomendacion r
										  								where r.id_usuario = (SELECT @contador))
												  and edad BETWEEN 21 and 30
												  GROUP BY palabra_buscada
												  HAVING COUNT(*)>1
												  ORDER BY COUNT(*) DESC)
				--select rec.*
				FROM recomendadordb.dbo.recomendacion as rec
				inner join usuario as u on u.id = rec.id_usuario
				WHERE u.id = (SELECT @contador)
				and edad BETWEEN 21 and 30;

				UPDATE rec
				SET rec.tercera_recomendacion = (SELECT TOP 1 palabra_buscada
												  -- select palabra_buscada, COUNT(*)
												  FROM recomendadordb.dbo.usuario
												  inner join busqueda on usuario.id = id_usuario
												  WHERE palabra_buscada <> (select primera_recomendacion
										  								from recomendadordb.dbo.recomendacion r
										  								where r.id_usuario = (SELECT @contador))
												  and palabra_buscada <> (select seguda_recomendacion
										  								from recomendadordb.dbo.recomendacion r
										  								where r.id_usuario = (SELECT @contador))
												  and edad BETWEEN 31 and 50
												  GROUP BY palabra_buscada
												  HAVING COUNT(*)>1
												  ORDER BY COUNT(*) DESC)
				--select rec.*
				FROM recomendadordb.dbo.recomendacion as rec
				inner join usuario as u on u.id = rec.id_usuario
				WHERE u.id = (SELECT @contador)
				and edad BETWEEN 31 and 50;

				UPDATE rec
				SET rec.tercera_recomendacion = (SELECT TOP 1 palabra_buscada
												  -- select palabra_buscada, COUNT(*)
												  FROM recomendadordb.dbo.usuario
												  inner join busqueda on usuario.id = id_usuario
												  WHERE palabra_buscada <> (select primera_recomendacion
										  								from recomendadordb.dbo.recomendacion r
										  								where r.id_usuario = (SELECT @contador))
												  and palabra_buscada <> (select seguda_recomendacion
										  								from recomendadordb.dbo.recomendacion r
										  								where r.id_usuario = (SELECT @contador))
												  and edad BETWEEN 51 and 80
												  GROUP BY palabra_buscada
												  HAVING COUNT(*)>1
												  ORDER BY COUNT(*) DESC)
				--select rec.*
				FROM recomendadordb.dbo.recomendacion as rec
				inner join usuario as u on u.id = rec.id_usuario
				WHERE u.id = (SELECT @contador)
				and edad BETWEEN 51 and 80;

				--*************************** CUARTA RECOMENDACION

				UPDATE rec
				 SET rec.cuarta_recomendacion = (SELECT TOP 1 palabra_buscada
												-- select palabra_buscada, COUNT(*)
												FROM recomendadordb.dbo.usuario 
												inner join busqueda on usuario.id = busqueda.id_usuario
												WHERE genero = 'masculino'
												and palabra_buscada <> (select primera_recomendacion
																		from recomendadordb.dbo.recomendacion r
																		where r.id_usuario = (SELECT @contador))
												and palabra_buscada <> (select seguda_recomendacion
																		from recomendadordb.dbo.recomendacion r
																		where r.id_usuario = (SELECT @contador))
												and palabra_buscada <> (select tercera_recomendacion
																		from recomendadordb.dbo.recomendacion r
																		where r.id_usuario = (SELECT @contador))
												GROUP BY palabra_buscada
												HAVING COUNT(*)>1
												ORDER BY COUNT(*) DESC)
				 --select rec.*
				 FROM recomendadordb.dbo.recomendacion as rec
				inner join recomendadordb.dbo.usuario as u on u.id = rec.id_usuario
				where rec.id_usuario = (SELECT @contador)
				and u.genero='masculino';
		
				UPDATE rec
				 SET rec.cuarta_recomendacion = (SELECT TOP 1 palabra_buscada
												-- select palabra_buscada, COUNT(*)
												FROM recomendadordb.dbo.usuario 
												inner join busqueda on usuario.id = busqueda.id_usuario
												WHERE genero = 'femenino'
												and palabra_buscada <> (select primera_recomendacion
																		from recomendadordb.dbo.recomendacion r
																		where r.id_usuario = (SELECT @contador))
												and palabra_buscada <> (select seguda_recomendacion
																		from recomendadordb.dbo.recomendacion r
																		where r.id_usuario = (SELECT @contador))
												and palabra_buscada <> (select tercera_recomendacion
																		from recomendadordb.dbo.recomendacion r
																		where r.id_usuario = (SELECT @contador))
												GROUP BY palabra_buscada
												HAVING COUNT(*)>1
												ORDER BY COUNT(*) DESC)
				 --select rec.*
				 FROM recomendadordb.dbo.recomendacion as rec
				inner join recomendadordb.dbo.usuario as u on u.id = rec.id_usuario
				where rec.id_usuario = (SELECT @contador)
				and u.genero='femenino';


		end

		--Select @contador
		SET @contador += 1

	 END

END

GO


