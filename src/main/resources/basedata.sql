INSERT INTO category (ckey, cval)
VALUES
	('style', 'tile'),
	('style', 'wrap'),
	('genre', 'Action'),
	('genre', 'Adventure'),
	('genre', 'Fantasy'),
	('genre', 'Thriller'),
	('genre', 'Sci-Fi'),
	('genre', 'Comedy'),
	('genre', 'Animation'),
	('genre', 'Biography'),
	('language', 'chinese'),
	('language', 'english'),
	('file_type', 'content'),
	('file_type', 'poster'),
	('file_type', 'srt'),
	('file_type', 'drm'),
	('file_type', 'description'),
  ('genre', 'Crime');


INSERT INTO director (first_name, last_name) 
VALUES 
  ('Baltasar', 'Kormákur'),
  ('Justin', 'Lin'),
  ('薇', '赵'),
  ('Shane', 'Black'),
  ('Jon M.', 'Chu');


INSERT INTO actor (first_name, last_name)
VALUES
  ('Mark', 'Wahlberg'),
  ('Denzel', 'Washington'),
  ('Vin', 'Diesel'),
  ('Paul', 'Walker'),
  ('Dwayne', 'Johnson'),
  ('Luke', 'Evans'),
  ('Michelle', 'Rodriguez'),
  ('Jordana', 'Brewster'),
  ('Sung', 'Kang'),
  ('Gina', 'Carano'),
  ('又廷', '赵'),
  ('庚', '韩'),
  ('子姗', '杨'),
  ('雅瑟', '刘'),
  ('Bruce', 'Willis'),
  ('Channing', 'Tatum'),
  ('Robert', 'Downey Jr.'),
  ('Gwyneth', 'Paltrow');


INSERT INTO menu (
	parent,
	category_style,
	name,
	display_order,
	path,
	has_child,
	valid,
	level,
	icon,
	focus_icon,
	remark
)
VALUES
  (NULL, 1, '', 0, '', 0, 0, 0, NULL, NULL, NULL),
	(1, 2, '蓝光影院', 1, '/2', 0, 0, 1, NULL, NULL, NULL),
  (1, 1, '纪录专区', 2, '/3', 1, 0, 1, NULL, NULL, NULL),
  (1, 1, '娱乐综合', 3, '/4', 0, 0, 1, NULL, NULL, NULL),
  (1, 1, '华语影院', 4, '/5', 0, 0, 1, NULL, NULL, NULL),
  (3, 1, 'BBC记录', 1, '/3/6', 0, 0, 2, NULL, NULL, NULL),
  (1, 1, '测试栏目', 5, '/7', 1, 0, 1, NULL, NULL, NULL),
  (7, 1, '测试综合', 1, '/7/8', 0, 0, 2, NULL, NULL, NULL);


INSERT INTO film (
  id, 
  title, 
  ratings,
  release_year, 
  country, 
  length, 
  description, 
  remark
)
VALUES 
-- ('id', 'title', 'ratings', 'release_year', 'country', length, 'description', null)
  ('embed01', 'G.I. Joe: Retaliation', '5.9/10 from 66,019 users', '2013', '美国', 123, '眼镜蛇这群恐怖分子又一次又有了新的目标，在控制住了所有国家的元首之后，他们终于开始要向美国总统动手了--他们的目标就是控制全世界。而特种部队这边则因为出现了叛徒而忙乱不已。因为上一次的交手，谁也没有赢，所以特种部队和眼镜蛇两方面都在寻找下一次袭击对方的机会。只是，这次的战斗对于特种部队来说更是难上加难。因为他们不仅仅要对付眼镜蛇这一伙人，还有自己的叛徒。除此之外，全世界被控制住的政要都开始反对特种部队了……', null),
  ('embed02', 'Iron Man 3', '7.5/10 from 245,915 users', '2013', '美国', 134, '在《钢铁侠3》中，托尼·斯塔克将遭遇到一个能力似乎没有界限的强敌的挑战。这个人毁坏了斯塔克的生活，而斯塔克只有依靠着自己精良的高科技的装备才能去寻找究竟是谁才是幕后的元凶。在寻找的过程中，斯塔克非常依赖自己的钢铁服，每一次转折都在测试着他的勇气。当他最终找到强敌，并且准备展开反戈一击的时候，斯塔克顿时发现了自己一直以来都面对着一个巨大的问题：到底是战衣造就了一个男人，还是这个男人成就了一套衣服！他必须揭发恐怖袭击背后的危机，与终极狂徒决一死战。　　托尼·斯塔克（小罗伯特·唐尼 Robert Downey Jr. 饰）遭遇到强敌挑战，这个人毁坏了托尼·斯塔克的生活，斯塔克为前所未有的焦虑症所困扰。与此同时，臭名昭著的恐怖头目满大人（本·金斯利 Ben Kingsley 饰）制造了一连串的爆炸袭击事件，托尼当年最忠诚的保镖即在最近的一次袭击中身负重伤。　　未过多久，托尼、小辣椒以及曾与他有过一面之缘的女植物学家玛雅（丽贝卡·豪尔 Rebecca Hall 饰）在家中遭到猛烈的炮火袭击，几乎丧命，而这一切似乎都与13年前那名偶然邂逅的科学家阿尔德里奇·基连（盖·皮尔斯 Guy Pearce 饰）及其终极生物的研究有关。　　而托尼·斯塔克只有依靠着自己精良的高科技的装备才能去寻找究竟是谁才是幕后的元凶。他疯狂投入钢铁侠升级版的研发，为此废寝忘食，甚至忽略了女友佩珀·波茨（格温妮斯·帕特洛 Gwyneth Paltrow 饰）。在寻找与对手对抗的过程中，斯塔克非常依赖自己的钢铁服，每一次转折都在测试着他的勇气。即使有精密先进的铠甲护身，也无法排遣发自心底的焦虑。　　之后他发现基连的真正目的：想利用终极生物来掌控全世界！并在小辣椒身上注射了终极生物的病毒，想把爱国者战甲和总统一起烧死！可托尼的钢铁军团也来到了，他们和基连的手下展开激战。　　终于，托尼和最终Boss（也就是真正的满大人）决一死战，并把42号毁掉，但仍然没有战胜基连，最后，以一台钢铁战衣为代价，基连终于被小辣椒击败。　　最后托尼来到中国，依靠手术清理了留在他身上的弹片，方舟反应堆（就是能量核）终于可以不要这个来维持他的生命，最后将其投入海里。而钢铁侠的传奇，就此化为传说......', null),
  ('embed03', '2 Guns', '6.9/10 from 30,816 users', '2013', '美国', 109, '     影片讲述的是美国缉毒局某探员和一位卧底海军军官之间的故事，在他们调查某个案件的时候发现自己都中了圈套……　　斯汀和鲍比是互不相识的两个特工，因为一次任务，这两个人偶遇了一起，并且有了一段让他们无法互相信任的过往。其实，鲍比是美国毒品管制所的特工，斯汀是海军所管辖的犯罪打击机构的特工。在一次抢劫案中，这两个特工莫名其妙的相遇了。　　其实，他们的相遇并不是偶然的，而是一次精心设计的圈套。这个圈套让两个特工都陷入了"抢劫"的案件中无法自拔，所涉及到的金额高达4000万美元。如此煞费苦心设计这个大圈套的幕后操手是CIA。而现在，斯汀和鲍比陷入到了CIA的追捕之中。为了证明自己的清白，他们只有把这笔巨款还到CIA，并找出幕后黑手。　　但是要做到这一切，还有一个最首要的附加条件--那就是保持活命。', null),
  ('embed04', '致我们终将逝去的青春', '6.3/10 from 641 users ', '2013', '中国', 131, '      18岁的郑微（杨子姗饰）满怀期冀地步入大学校园，开始她的追爱之旅。原来，郑微从小便与邻家的林静（韩庚饰）大哥哥青梅竹马，此次终于如愿考上林静所在学校的邻校，可以开诚布公地与之交往了。谁想迎接她的不是心上人的怀抱，而是命运的捉弄－－林静出国留学，杳无音信。郑微倍受打击，患难时刻却与室友阮莞（江疏影饰）、朱小北（刘雅瑟饰）、黎维娟（张瑶饰）及师哥老张（包贝尔饰）结下深厚友谊，在他们陪伴下慢慢走出心结。　　崭新的大学生活正式开启，在这个男多女少的理工院校，郑微和阮莞两大美女很受瞩目。富家公子许开阳（郑恺饰）便是郑微众多追求者中很有实力的一位，而阮莞用她特有的清冷守护着对于爱情的忠贞。一次偶然的误会使郑微与老张室友陈孝正（赵又廷饰）结为死敌，在一次次地反击中，郑微惊讶地发现自己爱上了这个表面冷酷、内心善良的高材生，于是疯狂地反击演变为死缠烂打地追求，而陈孝正也终于在强攻之下缴械投降，欢喜冤家终成甜蜜恋人。　　大学四年时光匆匆流逝，毕业在即的郑微憧憬着美好的未来，却再一次遭遇晴天霹雳：陈孝正迫于家庭压力选择出国留学，却迟迟不敢告诉郑微。感觉再次被欺骗的郑微痛苦地离开陈孝正，却遇到搂着新欢的许开阳，两下对比更觉世界的荒凉。但大家终于四散。　　多年以后的新世纪，郑微已蜕变为职场上的白领丽人，竟再次品尝命运的无常：带着悔意和爱意的林静和陈孝正同时回到她的生活里！郑微，这个昔日的玉面小飞龙，将怎样面对生活和青春赐予她的迷雾和抉择…', null),
  ('embed05', 'Fast & Furious 6', '7.3/10 from 134,955 users', '2013', '美国', 130, '　　上一集中，阿当（范·迪塞尔 Vin Diesel 饰）和布莱恩（保罗·沃克 Paul Walker 饰）率领的一众飊车好手反转里约热内卢，成功劫走当地大毒枭一亿美金后，各自散落世界各地，过着无忧无虑的生活；唯一遗憾是始终背负着逃犯之名，不能返回家乡与家人团聚。一天，刑警霍布斯（道恩·强森 Dwayne Johnson 饰）突然拜访，开出无法抗拒的条件利诱：清除他们历年来的犯罪纪录，让他们返回美国；代价是协助警方缉拿一队横行欧洲的雇佣兵团。 　　雇佣兵团由前特种部队军人欧文·肖（卢克·伊万斯 Luke Evans 饰）率领，犯案手法残暴冷血，而且接连向军方物资下手。在追捕过程中，阿当更发现组织其中一个要员，竟是死去的女友莱蒂（米歇尔·罗德里格兹 Michelle Rodriguez 饰）！“死而复生”的莱蒂行事变得心狠手辣，更向阿当开枪，狠下毒手…', null);


INSERT INTO film_director (director_id, film_id)
VALUES
  (5, 'embed01'),
  (4, 'embed02'),
  (1, 'embed03'),
  (3, 'embed04'),
  (2, 'embed05');


INSERT INTO film_actor (film_id, actor_id)
VALUES
  ('embed01', 15),
  ('embed01', 5),
  ('embed01', 16),
  ('embed02', 17),
  ('embed02', 18),
  ('embed03', 1),
  ('embed03', 2),
  ('embed04', 11),
  ('embed04', 12),
  ('embed04', 13),
  ('embed04', 14),
  ('embed05', 3),
  ('embed05', 4),
  ('embed05', 5),
  ('embed05', 6),
  ('embed05', 7),
  ('embed05', 8),
  ('embed05', 9),
  ('embed05', 10);

INSERT INTO film_genre (film_id, category_genre)
VALUES
  ('embed01', 3),
  ('embed01', 4),
  ('embed01', 7),
  ('embed02', 3),
  ('embed02', 4),
  ('embed02', 5),
  ('embed03', 3),
  ('embed03', 8),
  ('embed04', 5),
  ('embed05', 3),
  ('embed05', 18),
  ('embed05', 6);


INSERT INTO film_language (film_id, category_language)
VALUES
  ('embed01', 12),
  ('embed02', 12),
  ('embed03', 12),
  ('embed04', 11),
  ('embed05', 12);


INSERT INTO menu_film (menu_id, film_id, display_order) 
VALUES 
  (2, 'embed01', 1),
  (8, 'embed01', 2),
  (2, 'embed02', 1),
  (6, 'embed02', 2),
  (2, 'embed03', 1),
  (6, 'embed03', 2),
  (2, 'embed04', 1),
  (5, 'embed04', 2),
  (8, 'embed05', 1);

INSERT INTO file (
  film_id, category_film, file_name, remark
) 
values 
  ('embed01', 13, 'embed01.mkv', NULL),
  ('embed01', 14, 'embed01.png', NULL),
  ('embed01', 15, 'embed01.srt', NULL),
  ('embed01', 17, 'embed01.xml', NULL),
  ('embed02', 13, 'embed02.mkv', NULL),
  ('embed02', 14, 'embed02.png', NULL),
  ('embed02', 15, 'embed02.srt', NULL),
  ('embed02', 17, 'embed02.xml', NULL),
  ('embed03', 13, 'embed03.mkv', NULL),
  ('embed03', 14, 'embed03.png', NULL),
  ('embed03', 15, 'embed03.srt', NULL),
  ('embed03', 17, 'embed03.xml', NULL),
  ('embed04', 13, 'embed04.mkv', NULL),
  ('embed04', 14, 'embed04.png', NULL),
  ('embed04', 15, 'embed04.srt', NULL),
  ('embed04', 17, 'embed04.xml', NULL),
  ('embed05', 13, 'embed05.mkv', NULL),
  ('embed05', 14, 'embed05.png', NULL),
  ('embed05', 15, 'embed05.srt', NULL),
  ('embed05', 17, 'embed05.xml', NULL);

