USE [Bookworm]
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 2/18/2020 5:39:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comment](
	[ID] [varchar](100) NOT NULL,
	[CommentDate] [date] NULL,
	[UserID] [varchar](100) NOT NULL,
	[PostID] [varchar](100) NOT NULL,
	[Text] [nvarchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Photo]    Script Date: 2/18/2020 5:39:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Photo](
	[ID] [varchar](100) NOT NULL,
	[PhotoName] [varchar](100) NOT NULL,
	[Title] [nvarchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Poster]    Script Date: 2/18/2020 5:39:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Poster](
	[ID] [varchar](100) NOT NULL,
	[PostName] [nvarchar](100) NOT NULL,
	[UserID] [varchar](100) NOT NULL,
	[Image] [varchar](100) NULL,
	[Text] [nvarchar](1000) NULL,
	[PostingDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Report]    Script Date: 2/18/2020 5:39:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Report](
	[ID] [varchar](100) NOT NULL,
	[UserID] [varchar](100) NOT NULL,
	[PostID] [varchar](100) NOT NULL,
	[Content] [nvarchar](500) NOT NULL,
	[Text] [nvarchar](4000) NULL,
	[ReportDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Topic]    Script Date: 2/18/2020 5:39:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Topic](
	[ID] [varchar](100) NOT NULL,
	[Text] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TopicOfPoster]    Script Date: 2/18/2020 5:39:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TopicOfPoster](
	[TopicID] [varchar](100) NOT NULL,
	[PostID] [varchar](100) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 2/18/2020 5:39:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[ID] [varchar](100) NOT NULL,
	[AccountType] [bit] NULL,
	[Username] [varchar](100) NOT NULL,
	[Password] [varchar](100) NOT NULL,
	[DisplayName] [nvarchar](100) NOT NULL,
	[DateOfbirth] [date] NULL,
	[Hobbies] [nvarchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserPhoto]    Script Date: 2/18/2020 5:39:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserPhoto](
	[UserID] [varchar](100) NOT NULL,
	[PhotoID] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC,
	[PhotoID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c1', CAST(N'2019-10-12' AS Date), N'u2', N'po1', N'The show continues the nightmarish flashbacks to Annes childhood at the orphan asylum where she was abused regularly, and McNulty plays these scenes as engrossingly as her exuberant ones.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c10', CAST(N'2019-10-02' AS Date), N'u2', N'po1', N'The two pair raises Simba in the jungle. Living by the motto Hakuna Matata, you will get a giggle at their hilarious, fun-filled adventure. This book has been rated as five stars by major publishing houses.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c11', CAST(N'2019-10-03' AS Date), N'u4', N'po2', N'It is considered a very good book and it is recommended for young readers. Ideally, the target audience for this book would be ages 5 - 11 although some older children and adults love this book for its storyline and illustrations.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c12', CAST(N'2019-10-03' AS Date), N'u2', N'po3', N'This is one of the greatest books of all times. It has a good meaning and a great story plot.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c13', CAST(N'2019-10-04' AS Date), N'u3', N'po4', N'of my opinions, and anyway, how could I fall in love with a man so interested in destroying the universe, such an ignorant being.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c14', CAST(N'2019-10-05' AS Date), N'u6', N'po5', N'Although, as time progresses on, Anne realises this is not a game, and their lives are at risk. The way she acts in the beginning makes me not want to feel sorry for her, and it is really hard to relate to an obnoxious girl.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c15', CAST(N'2019-10-06' AS Date), N'u3', N'po6', N'The costumes, worn by the characters, suit them amazingly. They really help to show their personalities, for example the Cullen s all wear posh, dark, casual but elegant clothes, showing their gracefulness and richness.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c16', CAST(N'2019-10-07' AS Date), N'u2', N'po7', N'James however, wears an worn leather jacket, that shows he is a bit rugged and shows his toughness.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c17', CAST(N'2019-10-04' AS Date), N'u4', N'po8', N'Despite the periods of melancholy and turmoil, this season feels more energetic and subsequently lighter because of the faster pace.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c18', CAST(N'2019-10-05' AS Date), N'u4', N'po9', N'It also is more comfortable in its skin and handles humor in its everyday situations deftly while also poking fun at itself.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c19', CAST(N'2019-10-13' AS Date), N'u5', N'po1', N'A caper near the end of the season epitomizes how everything gels to create a thoroughly uplifting, and most importantly, entertaining adventure.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c2', CAST(N'2019-10-13' AS Date), N'u3', N'po2', N'These bouts of PTSD are sprinkled throughout the season, yet for some reason, the show has so far not seen fit to actually address them.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c20', CAST(N'2019-10-16' AS Date), N'u6', N'po4', N'The series youthful cast, in fact, steal the show from the already strong adult cast members who are game for anything, including looking foolish in the most delightful way.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c20200218172622', CAST(N'2020-02-18' AS Date), N'u5', N'po12', N'xcvbxcbxcvcx')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c21', CAST(N'2019-10-17' AS Date), N'u2', N'po5', N'It takes its time to breathe and build out Avonlea, truly creating a fuller picture of a community that is not just in place to provide a backdrop for Anne’s shenanigans and growth.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c22', CAST(N'2019-10-19' AS Date), N'u3', N'po2', N'Each complete and satisfying episode deserves to be thoroughly digested before rushing headlong to the next. If only Netflix allowed users to permanently disable auto play.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c23', CAST(N'2019-10-14' AS Date), N'u6', N'po7', N'Besides, a quick consumption of the season means that much longer a wait for the next installment. Thus, viewers would be wise to take a page from Anne herself and savor the now to the fullest.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c24', CAST(N'2019-10-13' AS Date), N'u2', N'po4', N'I loved this season. I think it’s a moving portrait of childhood, a pioneering community and the progress of society in Canada.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c3', CAST(N'2019-10-14' AS Date), N'u4', N'po3', N'Book Riot is a blog. It publishes listicles on dozens of different topics, many of which focus on the best books in a certain genre.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c4', CAST(N'2019-10-15' AS Date), N'u5', N'po4', N'Of course, there is also plenty of non-reading list content. If you have a general affinity for literature, Book Riot is definitely worth adding to list of websites you browse every day.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c5', CAST(N'2019-10-16' AS Date), N'u6', N'po5', N'Besides winning in the same two categories in the Golden Globe Awards, it also won Best Motion Picture - Musical or Comedy. Later it was made into a picture book for young readers.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c6', CAST(N'2019-10-17' AS Date), N'u2', N'po6', N'The story has been perfected in every way. Fantastic and colourful pictures leap out in front of the reader, the well-structured layout of the pictures and text and the inclusion of many morals about life that leaves you nodding with agreement.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c7', CAST(N'2019-10-18' AS Date), N'u3', N'po7', N'Simba realises that family and friends are more important than power and succession. He realises that mistakes occur everyday and it is better to fix the problem rather than ignore it.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c8', CAST(N'2019-10-01' AS Date), N'u2', N'po8', N'At the beginning of the story, Rafiki the mandrill shaman presents Simba, the newborn cub of King Mufasa and Queen Sarabi, to a gathering of animals at Pride Rock.')
INSERT [dbo].[Comment] ([ID], [CommentDate], [UserID], [PostID], [Text]) VALUES (N'c9', CAST(N'2019-10-02' AS Date), N'u5', N'po8', N'Meanwhile, Mufasa younger brother, Scar, realizes that he is no longer the heir to the throne and plots to kill Simba and Mufasa. ')
INSERT [dbo].[Photo] ([ID], [PhotoName], [Title]) VALUES (N'p1', N'uphoto1.jpg', N'My photo')
INSERT [dbo].[Photo] ([ID], [PhotoName], [Title]) VALUES (N'p2', N'uphoto2.jpg', N'My Best photo took Yesterday')
INSERT [dbo].[Photo] ([ID], [PhotoName], [Title]) VALUES (N'p3', N'uphoto3.jpg', N'My photo on Montain')
INSERT [dbo].[Photo] ([ID], [PhotoName], [Title]) VALUES (N'p4', N'uphoto4.jpg', N'This photo is taken by be uncle on our trip last month')
INSERT [dbo].[Photo] ([ID], [PhotoName], [Title]) VALUES (N'p5', N'uphoto5.jpg', N'My photo is sexy right?')
INSERT [dbo].[Photo] ([ID], [PhotoName], [Title]) VALUES (N'p6', N'uphoto6.jpg', N'A lot of you asked me to post my photo so this is my personal photo')
INSERT [dbo].[Poster] ([ID], [PostName], [UserID], [Image], [Text], [PostingDate]) VALUES (N'po1', N'Harry Potter and the Philosopher Stone', N'u2', N'annewithane.jpg', N'One of feminism s paradoxes—one that challenges many of its optimistic histories—is how patriarchy remains persistent over time. While Judith Bennetts Ale Beer and Brewsters in England: Womens Work in a Changing World 1300-1600 recognizes medieval women as historical actors through their ale brewing it also shows that female agency had its limits with the advent of beer. I had assumed that those limits were religious and political but Bennett shows how a patriarchal equilibrium shut women out of economic life as well. Her analysis of womens wages in ale and beer production proves that a change in womens work does not equate to a change in working womens status. Contemporary feminists and historians alike should read Bennetts book and think twice when they crack open their next brewsky.', CAST(N'2019-11-19' AS Date))
INSERT [dbo].[Poster] ([ID], [PostName], [UserID], [Image], [Text], [PostingDate]) VALUES (N'po10', N'Anne with an E - The book you have to read in life', N'u3', N'postphoto10.jpg', N'I wish I had read the reviews on CSM before watching, but I never considered that anything based on AoGG would be anything but completely appropriatefora girl my daughters age. We loved the first 30 minutes of the first episode and then it went very wrong. It stopped following the book and added dark, nasty, grim events that never happened in the book. I stopped allowing my daughter to watch, but continued for myself. The third episode referred explicitly to sex and implied molestation, and the entire 4th episode was about menstruation.', CAST(N'2019-03-21' AS Date))
INSERT [dbo].[Poster] ([ID], [PostName], [UserID], [Image], [Text], [PostingDate]) VALUES (N'po11', N'Flash cards for learning English', N'u4', N'postphoto11.jpg', N'The flashbacks about the characters past are dark and spooky. Mamas wake up, the children in this series have NO CHILDHOOD! I kept waiting for them to have adventures, play games, things that children would have been doing then and should be doing NOW! When NETFLIX creates WHOLESOME kid friendly programs that are SEX free we will watch.... until then, L.M. Montgomery we will honor you by turning off the TV and reading your beautiful written stories for children about children. Mamas if we support content like this, they will continue to create darker and darker things for our kids to consume. Dont feed their tiny brains poison, feed it good things so they can grow slow and healthy. They have the rest of their lives to watch mature content if they choose. We as mothers should not have to pause the movie and explain (sex) every 5 mins to a young child nor should I have to watch with one hand on the remote because I DONT trust the content of a KID movie! really', CAST(N'2019-10-01' AS Date))
INSERT [dbo].[Poster] ([ID], [PostName], [UserID], [Image], [Text], [PostingDate]) VALUES (N'po12', N'How to be a good daughter - Make you parents proud of you', N'u5', N'postphoto12.jpg', N'We were very excited with my daughter as we had finally found a show that was unlike the rest of today. Annes first season was one of many do overs on the classical story by Canadian author Lucy Maud. The beautiful scenery caught our attention and the innocence of those times drew us in. We awaited the shows second season due to the above mentioned reasons, however came to quickly realize the shows new forthright direction moving toward more of an LGBT agenda that perplexed me even a well lived 27 year old mother to an 8 year old. The show quickly lost its tasteful innocence becoming a plot of gender confusion.', CAST(N'2018-10-23' AS Date))
INSERT [dbo].[Poster] ([ID], [PostName], [UserID], [Image], [Text], [PostingDate]) VALUES (N'po2', N'Harry Potter and the chamber of secrets', N'u2', N'postphoto2.jpg', N'Judith Bennetts Ale, Beer, and Brewsters in England: Womens Work in a Changing World, 1300-1600 was a colossal disappointment. I wanted to know about the rituals surrounding drinking in medieval England: the songs, the games, the parties. Bennett provided none of that information. I liked how the book showed ale and beer brewing as an economic activity, but the reader gets lost in the details of prices and wages. I was more interested in the private lives of the women brewsters. The book was divided into eight long chapters, and I cant imagine why anyone would ever want to read it.', CAST(N'2019-01-01' AS Date))
INSERT [dbo].[Poster] ([ID], [PostName], [UserID], [Image], [Text], [PostingDate]) VALUES (N'po20200218172004', N'Catch me if you can', N'u2', N'cebupacific-booking.jpg', N'khá là oce', CAST(N'2020-02-18' AS Date))
INSERT [dbo].[Poster] ([ID], [PostName], [UserID], [Image], [Text], [PostingDate]) VALUES (N'po3', N'History of the world war - Chapter 2', N'u3', N'IamSmart.jpg', N'Judith Bennetts Ale, Beer, and Brewsters in England: Womens Work in a Changing World, 1300-1600, investigates how women used to brew and sell the majority of ale drunk in England. Historically, ale and beer not milk, wine, or water were important elements of the English diet. Ale brewing was low-skill and low status labor that was complimentary to womens domestic responsibilities. In the early fifteenth century, brewers began to make ale with hops, and they called this new drink beer. This technique allowed brewers to produce their beverages at a lower cost and to sell it more easily, although women generally stopped brewing once the business became more profitable.', CAST(N'2019-08-08' AS Date))
INSERT [dbo].[Poster] ([ID], [PostName], [UserID], [Image], [Text], [PostingDate]) VALUES (N'po4', N'History of the world war - Chapter 1', N'u5', N'postphoto4.jpg', N'Reviewing can be a daunting task. Someone has asked for your opinion about something that you may feel unqualified to evaluate. Who are you to criticize Toni Morrisons new book if you have never written a novel yourself, much less won a Nobel Prize? The point is that someone—a professor, a journal editor, peers in a study group—wants to know what you think about a particular work. You may not be or feel like an expert, but you need to pretend to be one for your particular audience. Nobody expects you to be the intellectual equal of the works creator, but your careful observations can provide you with the raw material to make reasoned judgments. Tactfully voicing agreement and disagreement, praise and criticism, is a valuable, challenging skill, and like many forms of writing, reviews require you to provide concrete evidence for your assertions.', CAST(N'2019-10-16' AS Date))
INSERT [dbo].[Poster] ([ID], [PostName], [UserID], [Image], [Text], [PostingDate]) VALUES (N'po5', N'How to get away with murder - The book for Law Students', N'u4', N'postphoto5.jpg', N'This students review avoids the problems of the previous two examples. It combines balanced opinion and concrete example, a critical assessment based on an explicitly stated rationale, and a recommendation to a potential audience. The reader gets a sense of what the books author intended to demonstrate. Moreover, the student refers to an argument about feminist history in general that places the book in a specific genre and that reaches out to a general audience. The example of analyzing wages illustrates an argument, the analysis engages significant intellectual debates, and the reasons for the overall positive review are plainly visible. The review offers criteria, opinions, and support with which the reader can agree or disagree.', CAST(N'2019-02-12' AS Date))
INSERT [dbo].[Poster] ([ID], [PostName], [UserID], [Image], [Text], [PostingDate]) VALUES (N'po6', N'Life of pi - How to survive within a Lion', N'u3', N'postphoto6.jpg', N'Once you have made your observations and assessments of the work under review, carefully survey your notes and attempt to unify your impressions into a statement that will describe the purpose or thesis of your review. Check out our handout on thesis statements. Then, outline the arguments that support your thesis. Your arguments should develop the thesis in a logical manner. That logic, unlike more standard academic writing, may initially emphasize the authors argument while you develop your own in the course of the review. The relative emphasis depends on the nature of the review: if readers may be more interested in the work itself, you may want to make the work and the author more prominent if you want the review to be about your perspective and opinions, then you may structure the review to privilege your observations over but never separate from those of the work under review. What follows is just one of many ways to organize a review.', CAST(N'2019-06-06' AS Date))
INSERT [dbo].[Poster] ([ID], [PostName], [UserID], [Image], [Text], [PostingDate]) VALUES (N'po7', N'Romeo and Juliet - Book for the couple in love ', N'u2', N'postphoto7.jpg', N'Your analysis and evaluation should be organized into paragraphs that deal with single aspects of your argument. This arrangement can be challenging when your purpose is to consider the book as a whole, but it can help you differentiate elements of your criticism and pair assertions with evidence more clearly. You do not necessarily need to work chronologically through the book as you discuss it. Given the argument you want to make, you can organize your paragraphs more usefully by themes, methods, or other elements of the book. If you find it useful to include comparisons to other books, keep them brief so that the book under review remains in the spotlight. Avoid excessive quotation and give a specific page reference in parentheses when you do quote. Remember that you can state many of the authors points in your own words.', CAST(N'2019-05-01' AS Date))
INSERT [dbo].[Poster] ([ID], [PostName], [UserID], [Image], [Text], [PostingDate]) VALUES (N'po8', N'The book for all of people who want to be famous', N'u6', N'postphoto8.jpg', N'Sum up or restate your thesis or make the final judgment regarding the book. You should not introduce new evidence for your argument in the conclusion. You can, however, introduce new ideas that go beyond the book if they extend the logic of your own thesis. This paragraph needs to balance the books strengths and weaknesses in order to unify your evaluation. Did the body of your review have three negative paragraphs and one favorable one What do they all add up to. The Writing Centers handout on conclusions can help you make a final assessment.', CAST(N'2019-01-02' AS Date))
INSERT [dbo].[Poster] ([ID], [PostName], [UserID], [Image], [Text], [PostingDate]) VALUES (N'po9', N'Peper pan book is such a lot of Mysteries', N'u6', N'postphoto9.jpg', N'In episode 3, Anne says she thinks the headmaster is having intimate relations with a student and then talks about the pet mouse all men have that they carry in their front pocket and when women stroke it they have a baby. A few minutes later she talks about a family she used to live with how he wanted his wife to pet his mouse when he got drunk. And more details. Definitely not the Anne we know and love and trust our kids to watch. Disappointed.', CAST(N'2019-07-08' AS Date))
INSERT [dbo].[Report] ([ID], [UserID], [PostID], [Content], [Text], [ReportDate]) VALUES (N'r1', N'u2', N'po1', N'Sexual Content', N'I hope that Inthe future, those posts like this will be deleted from this network', CAST(N'2019-10-12' AS Date))
INSERT [dbo].[Report] ([ID], [UserID], [PostID], [Content], [Text], [ReportDate]) VALUES (N'r2', N'u3', N'po2', N'Spam', N'please check the content of this post,it is marketing', CAST(N'2019-10-14' AS Date))
INSERT [dbo].[Report] ([ID], [UserID], [PostID], [Content], [Text], [ReportDate]) VALUES (N'r20200218173020', N'a1', N'po20200218172004', N'Spam post', N'remove it please', CAST(N'2020-02-18' AS Date))
INSERT [dbo].[Topic] ([ID], [Text]) VALUES (N't1', N'Science Fiction')
INSERT [dbo].[Topic] ([ID], [Text]) VALUES (N't10', N'Dog')
INSERT [dbo].[Topic] ([ID], [Text]) VALUES (N't11', N'Life')
INSERT [dbo].[Topic] ([ID], [Text]) VALUES (N't12', N'Cookbooks')
INSERT [dbo].[Topic] ([ID], [Text]) VALUES (N't2', N'Action and Adventure')
INSERT [dbo].[Topic] ([ID], [Text]) VALUES (N't3', N'Self help')
INSERT [dbo].[Topic] ([ID], [Text]) VALUES (N't4', N'Dictionaries')
INSERT [dbo].[Topic] ([ID], [Text]) VALUES (N't5', N'Science')
INSERT [dbo].[Topic] ([ID], [Text]) VALUES (N't6', N'Math')
INSERT [dbo].[Topic] ([ID], [Text]) VALUES (N't7', N'Comics')
INSERT [dbo].[Topic] ([ID], [Text]) VALUES (N't8', N'Biographies')
INSERT [dbo].[Topic] ([ID], [Text]) VALUES (N't9', N'Autobiographies')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't1', N'po1')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't2', N'po1')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't3', N'po2')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't4', N'po2')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't1', N'po3')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't1', N'po4')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't5', N'po4')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't6', N'po5')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't7', N'po6')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't8', N'po6')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't4', N'po7')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't5', N'po8')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't9', N'po8')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't10', N'po9')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't11', N'po10')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't6', N'po11')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't2', N'po12')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't7', N'po12')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't1', N'po20200218172004')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't11', N'po20200218172004')
INSERT [dbo].[TopicOfPoster] ([TopicID], [PostID]) VALUES (N't12', N'po20200218172004')
INSERT [dbo].[User] ([ID], [AccountType], [Username], [Password], [DisplayName], [DateOfbirth], [Hobbies]) VALUES (N'a1', 1, N'admin1', N'password1', N'Hải Ngân', CAST(N'1999-12-12' AS Date), N'Football , Badminton')
INSERT [dbo].[User] ([ID], [AccountType], [Username], [Password], [DisplayName], [DateOfbirth], [Hobbies]) VALUES (N'u2', 0, N'username2', N'password2', N'Sam Smith', CAST(N'1999-12-02' AS Date), N'Play Football , Badminton')
INSERT [dbo].[User] ([ID], [AccountType], [Username], [Password], [DisplayName], [DateOfbirth], [Hobbies]) VALUES (N'u3', 0, N'username3', N'password3', N'Dean Lewis', CAST(N'1999-11-03' AS Date), N'Cheating , Chating')
INSERT [dbo].[User] ([ID], [AccountType], [Username], [Password], [DisplayName], [DateOfbirth], [Hobbies]) VALUES (N'u4', 0, N'username4', N'password4', N'Rick Hale', CAST(N'1999-10-04' AS Date), N'Gameming , Typing')
INSERT [dbo].[User] ([ID], [AccountType], [Username], [Password], [DisplayName], [DateOfbirth], [Hobbies]) VALUES (N'u5', 0, N'username5', N'password5', N'Alexander Hiếu', CAST(N'1999-09-05' AS Date), N'Reading , Badminton')
INSERT [dbo].[User] ([ID], [AccountType], [Username], [Password], [DisplayName], [DateOfbirth], [Hobbies]) VALUES (N'u6', 0, N'username6', N'password6', N'Lý Tiểu Long', CAST(N'1999-08-06' AS Date), N'Wringting novel , Football')
INSERT [dbo].[UserPhoto] ([UserID], [PhotoID]) VALUES (N'a1', N'p1')
INSERT [dbo].[UserPhoto] ([UserID], [PhotoID]) VALUES (N'u2', N'p2')
INSERT [dbo].[UserPhoto] ([UserID], [PhotoID]) VALUES (N'u3', N'p3')
INSERT [dbo].[UserPhoto] ([UserID], [PhotoID]) VALUES (N'u4', N'p4')
INSERT [dbo].[UserPhoto] ([UserID], [PhotoID]) VALUES (N'u5', N'p5')
INSERT [dbo].[UserPhoto] ([UserID], [PhotoID]) VALUES (N'u6', N'p6')
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD FOREIGN KEY([PostID])
REFERENCES [dbo].[Poster] ([ID])
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Poster]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Report]  WITH CHECK ADD FOREIGN KEY([PostID])
REFERENCES [dbo].[Poster] ([ID])
GO
ALTER TABLE [dbo].[Report]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[TopicOfPoster]  WITH CHECK ADD FOREIGN KEY([PostID])
REFERENCES [dbo].[Poster] ([ID])
GO
ALTER TABLE [dbo].[TopicOfPoster]  WITH CHECK ADD FOREIGN KEY([TopicID])
REFERENCES [dbo].[Topic] ([ID])
GO
ALTER TABLE [dbo].[UserPhoto]  WITH CHECK ADD FOREIGN KEY([PhotoID])
REFERENCES [dbo].[Photo] ([ID])
GO
ALTER TABLE [dbo].[UserPhoto]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[User] ([ID])
GO
