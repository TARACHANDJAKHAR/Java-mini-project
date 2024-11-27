CREATE DATABASE assignment8;
USE assignment8;
select * from course;
create table userinfo(
username varchar(50),
password varchar(50));
insert userinfo values
("2401","12345"),("2402","12345"),("2403","12345"),("2404","12345"),("2405","12345"),("2406","12345"),("2407","12345"),("2408","12345"),("2409","12345"),("2410","12345"),
("2411","12345"),("2412","12345"),("2413","12345"),("2414","12345"),("2415","12345"),("2416","12345"),("2417","12345"),("2418","12345"),("2419","12345"),("2420","12345"),
("2301","12346"),("2302","12346"),("2303","12346"),("2304","12346"),("2305","12346"),("2306","12346"),("2307","12346"),("2308","12346"),("2309","12346"),("2310","12346"),
("2311","12346"),("2312","12346"),("2313","12346"),("2314","12346"),("2315","12346"),("2316","12346"),("2317","12346"),("2318","12346"),("2319","12346"),("2320","12346"),
("2201","12347"),("2202","12347"),("2203","12347"),("2204","12347"),("2205","12347"),("2206","12347"),("2207","12347"),("2208","12347"),("2209","12347"),("2210","12347"),
("2211","12347"),("2212","12347"),("2213","12347"),("2214","12347"),("2215","12347"),("2216","12347"),("2217","12347"),("2218","12347"),("2219","12347"),("2220","12347"),
("2101","12348"),("2102","12348"),("2103","12348"),("2104","12348"),("2105","12348"),("2106","12348"),("2107","12348"),("2108","12348"),("2109","12348"),("2110","12348"),
("2111","12348"),("2112","12348"),("2113","12348"),("2114","12348"),("2115","12348"),("2116","12348"),("2117","12348"),("2118","12348"),("2119","12348"),("2120","12348");
insert userinfo values
('1', '123456'),('2', '123456'),('3', '123456'),('4', '123456'),('5', '123456'),('6', '123456'),('7', '123456'),('8', '123456'),('9', '123456'),('10', '123456'),
('11', '123456'),('12', '123456'),('13', '123456'),('14', '123456'),('15', '123456'),('16', '123456'),('17', '123456'),('18', '123456'),('19', '123456'),('20','123456');
insert userinfo values ('100',1234);
Select * from userinfo;
drop table userinfo; 
use assignment8;
select * from students;
CREATE TABLE Students (
    StudentID INT PRIMARY KEY ,
    Name VARCHAR(100) NOT NULL,
    Department VARCHAR(50),
    Semester INT,
    Email VARCHAR(100),
    reg Varchar(2)
);
SET SQL_SAFE_UPDATES = 0;



update students set  reg =1;
select * from students;


-- CREATE TABLE Admin (
--     AdminID INT PRIMARY KEY ,
--     Name VARCHAR(100) NOT NULL,
--     Role VARCHAR(50),
--     Email VARCHAR(100)
-- );

CREATE TABLE Course (
    CourseID INT PRIMARY KEY ,
    CourseName VARCHAR(100) NOT NULL,
    Credits INT NOT NULL,
    Department VARCHAR(50),
    Semester INT
);

-- CREATE TABLE SemesterCourses (
--     SemesterCourseID INT PRIMARY KEY ,
--     CourseID INT,
--     Semester INT,
--     ProfessorID INT,
--     FOREIGN KEY (CourseID) REFERENCES Course(CourseID),
--     FOREIGN KEY (ProfessorID) REFERENCES Professor(ProfessorID)
-- );

-- CREATE TABLE Enrollment (
--     EnrollmentID INT PRIMARY KEY ,
--     StudentID INT,
--     SemesterCourseID INT,
--     EnrollmentDate DATE,
--     FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
--     FOREIGN KEY (SemesterCourseID) REFERENCES SemesterCourses(SemesterCourseID)
-- );

-- CREATE TABLE AdminRolePermissions (
--     RoleID INT PRIMARY KEY AUTO_INCREMENT,
--     Role VARCHAR(50),
--     Permission VARCHAR(100)
-- );

INSERT INTO Students (StudentID, Name, Department, Semester, Email) VALUES

(2401, 'Rajesh Kumar', 'Computer Science', 1, 'rajesh.kumar@university.edu'),
(2402, 'Anjali Sharma', 'Computer Science', 1, 'anjali.sharma@university.edu'),
(2403, 'Vikram Singh', 'Mechanical Engineering', 1, 'vikram.singh@university.edu'),
(2404, 'Sneha Verma', 'Civil Engineering', 1, 'sneha.verma@university.edu'),
(2405, 'Suresh Patel', 'Electrical Engineering', 1, 'suresh.patel@university.edu'),
(2406, 'Nisha Reddy', 'Electronics', 1, 'nisha.reddy@university.edu'),
(2407, 'Aman Thakur', 'Mechanical Engineering', 1, 'aman.thakur@university.edu'),
(2408, 'Karan Joshi', 'Computer Science', 1, 'karan.joshi@university.edu'),
(2409, 'Shweta Mishra', 'Civil Engineering', 1, 'shweta.mishra@university.edu'),
(2410, 'Manoj Desai', 'Electrical Engineering', 1, 'manoj.desai@university.edu'),


(2301, 'Rohit Jain', 'Electronics', 3, 'rohit.jain@university.edu'),
(2302, 'Priya Iyer', 'Mechanical Engineering', 3, 'priya.iyer@university.edu'),
(2303, 'Gaurav Yadav', 'Civil Engineering', 3, 'gaurav.yadav@university.edu'),
(2304, 'Neha Kapoor', 'Computer Science', 3, 'neha.kapoor@university.edu'),
(2305, 'Ramesh Nair', 'Electrical Engineering', 3, 'ramesh.nair@university.edu'),
(2306, 'Kavita Sharma', 'Mechanical Engineering', 3, 'kavita.sharma@university.edu'),
(2307, 'Vinod Patil', 'Civil Engineering', 3, 'vinod.patil@university.edu'),
(2308, 'Rahul Batra', 'Computer Science', 3, 'rahul.batra@university.edu'),
(2309, 'Meena Joshi', 'Electronics', 3, 'meena.joshi@university.edu'),
(2310, 'Pooja Kulkarni', 'Electrical Engineering', 3, 'pooja.kulkarni@university.edu'),

(2201, 'Kavita Gupta', 'Computer Science', 5, 'kavita.gupta@university.edu'),
(2202, 'Abhishek Mehta', 'Electrical Engineering', 5, 'abhishek.mehta@university.edu'),
(2203, 'Manish Tiwari', 'Mechanical Engineering', 5, 'manish.tiwari@university.edu'),
(2204, 'Ruchi Desai', 'Electronics', 5, 'ruchi.desai@university.edu'),
(2205, 'Amit Jain', 'Civil Engineering', 5, 'amit.jain@university.edu'),
(2206, 'Deepika Agarwal', 'Computer Science', 5, 'deepika.agarwal@university.edu'),
(2207, 'Vikas Pandey', 'Mechanical Engineering', 5, 'vikas.pandey@university.edu'),
(2208, 'Neeraj Singh', 'Electrical Engineering', 5, 'neeraj.singh@university.edu'),
(2209, 'Arjun Khanna', 'Electronics', 5, 'arjun.khanna@university.edu'),
(2210, 'Sunita Malhotra', 'Civil Engineering', 5, 'sunita.malhotra@university.edu'),


(2101, 'Deepak Malhotra', 'Electronics', 7, 'deepak.malhotra@university.edu'),
(2102, 'Swati Desai', 'Civil Engineering', 7, 'swati.desai@university.edu'),
(2103, 'Harsh Patel', 'Computer Science', 7, 'harsh.patel@university.edu'),
(2104, 'Nidhi Sharma', 'Mechanical Engineering', 7, 'nidhi.sharma@university.edu'),
(2105, 'Rajat Verma', 'Electrical Engineering', 7, 'rajat.verma@university.edu'),
(2106, 'Sonal Kapoor', 'Civil Engineering', 7, 'sonal.kapoor@university.edu'),
(2107, 'Aakash Gupta', 'Electronics', 7, 'aakash.gupta@university.edu'),
(2108, 'Kiran Reddy', 'Computer Science', 7, 'kiran.reddy@university.edu'),
(2109, 'Vivek Bansal', 'Mechanical Engineering', 7, 'vivek.bansal@university.edu'),
(2110, 'Tanvi Chauhan', 'Electrical Engineering', 7, 'tanvi.chauhan@university.edu');
-- even semester 
INSERT INTO Students (StudentID, Name, Department, Semester, Email) VALUES
-- First Year (Starting with 2411 for Semester 2)
(2411, 'Arjun Verma', 'Computer Science', 2, 'arjun.verma@university.edu'),
(2412, 'Suman Patel', 'Mechanical Engineering', 2, 'suman.patel@university.edu'),
(2413, 'Riya Gupta', 'Civil Engineering', 2, 'riya.gupta@university.edu'),
(2414, 'Rahul Iyer', 'Electrical Engineering', 2, 'rahul.iyer@university.edu'),
(2415, 'Deepika Sharma', 'Electronics', 2, 'deepika.sharma@university.edu'),
(2416, 'Kunal Desai', 'Computer Science', 2, 'kunal.desai@university.edu'),
(2417, 'Nisha Singh', 'Mechanical Engineering', 2, 'nisha.singh@university.edu'),
(2418, 'Vikram Rao', 'Civil Engineering', 2, 'vikram.rao@university.edu'),
(2419, 'Sneha Kapoor', 'Electrical Engineering', 2, 'sneha.kapoor@university.edu'),
(2420, 'Ravi Kumar', 'Electronics', 2, 'ravi.kumar@university.edu'),

-- Second Year (Starting with 2311 for Semester 4)
(2311, 'Vikrant Sharma', 'Computer Science', 4, 'vikrant.sharma@university.edu'),
(2312, 'Anjali Joshi', 'Mechanical Engineering', 4, 'anjali.joshi@university.edu'),
(2313, 'Ajay Yadav', 'Civil Engineering', 4, 'ajay.yadav@university.edu'),
(2314, 'Priyanka Nair', 'Electrical Engineering', 4, 'priyanka.nair@university.edu'),
(2315, 'Karan Mehta', 'Electronics', 4, 'karan.mehta@university.edu'),
(2316, 'Nikhil Patil', 'Computer Science', 4, 'nikhil.patil@university.edu'),
(2317, 'Meera Iyer', 'Mechanical Engineering', 4, 'meera.iyer@university.edu'),
(2318, 'Ashish Reddy', 'Civil Engineering', 4, 'ashish.reddy@university.edu'),
(2319, 'Rina Singh', 'Electrical Engineering', 4, 'rina.singh@university.edu'),
(2320, 'Sonam Sharma', 'Electronics', 4, 'sonam.sharma@university.edu'),

-- Third Year (Starting with 2211 for Semester 6)
(2211, 'Rohan Gupta', 'Computer Science', 6, 'rohan.gupta@university.edu'),
(2212, 'Kriti Bansal', 'Mechanical Engineering', 6, 'kriti.bansal@university.edu'),
(2213, 'Pritam Yadav', 'Civil Engineering', 6, 'pritam.yadav@university.edu'),
(2214, 'Nitin Singh', 'Electrical Engineering', 6, 'nitin.singh@university.edu'),
(2215, 'Tanvi Joshi', 'Electronics', 6, 'tanvi.joshi@university.edu'),
(2216, 'Arvind Reddy', 'Computer Science', 6, 'arvind.reddy@university.edu'),
(2217, 'Surbhi Patel', 'Mechanical Engineering', 6, 'surbhi.patel@university.edu'),
(2218, 'Kunal Mehta', 'Civil Engineering', 6, 'kunal.mehta@university.edu'),
(2219, 'Vivek Desai', 'Electrical Engineering', 6, 'vivek.desai@university.edu'),
(2220, 'Shikha Malhotra', 'Electronics', 6, 'shikha.malhotra@university.edu'),

-- Fourth Year (Starting with 2111 for Semester 8)
(2111, 'Deepak Agarwal', 'Computer Science', 8, 'deepak.agarwal@university.edu'),
(2112, 'Sonal Bansal', 'Mechanical Engineering', 8, 'sonal.bansal@university.edu'),
(2113, 'Amit Sharma', 'Civil Engineering', 8, 'amit.sharma@university.edu'),
(2114, 'Neha Reddy', 'Electrical Engineering', 8, 'neha.reddy@university.edu'),
(2115, 'Rajesh Tiwari', 'Electronics', 8, 'rajesh.tiwari@university.edu'),
(2116, 'Kajal Iyer', 'Computer Science', 8, 'kajal.iyer@university.edu'),
(2117, 'Arnav Gupta', 'Mechanical Engineering', 8, 'arnav.gupta@university.edu'),
(2118, 'Vani Yadav', 'Civil Engineering', 8, 'vani.yadav@university.edu'),
(2119, 'Parul Verma', 'Electrical Engineering', 8, 'parul.verma@university.edu'),
(2120, 'Harsh Jain', 'Electronics', 8, 'harsh.jain@university.edu');


 -- courses data registration
 Select CourseID, CourseName from course where department= 'Computer Science' and semester=2;
 INSERT INTO Course (CourseID, CourseName, Department, Semester, Credits) VALUES
-- Computer Science Courses (Semesters 1 to 8)
(101, 'Introduction to Programming', 'Computer Science', 1, 4),
(102, 'Discrete Mathematics', 'Computer Science', 1, 4),
(103, 'Computer Organization', 'Computer Science', 1, 4),
(104, 'Mathematics I', 'Computer Science', 1, 4),
(105, 'Digital Logic', 'Computer Science', 1, 4),
(201, 'Data Structures', 'Computer Science', 2, 4),
(202, 'Algorithms', 'Computer Science', 2, 4),
(203, 'Database Systems', 'Computer Science', 2, 4),
(204, 'Mathematics II', 'Computer Science', 2, 4),
(205, 'Object-Oriented Programming', 'Computer Science', 2, 4),
(301, 'Operating Systems', 'Computer Science', 3, 4),
(302, 'Theory of Computation', 'Computer Science', 3, 4),
(303, 'Computer Networks', 'Computer Science', 3, 4),
(304, 'Software Engineering', 'Computer Science', 3, 4),
(305, 'Artificial Intelligence', 'Computer Science', 3, 4),
(401, 'Machine Learning', 'Computer Science', 4, 4),
(402, 'Web Development', 'Computer Science', 4, 4),
(403, 'Data Mining', 'Computer Science', 4, 4),
(404, 'Compiler Design', 'Computer Science', 4, 4),
(405, 'Computer Graphics', 'Computer Science', 4, 4),
(501, 'Distributed Systems', 'Computer Science', 5, 4),
(502, 'Cloud Computing', 'Computer Science', 5, 4),
(503, 'Mobile Application Development', 'Computer Science', 5, 4),
(504, 'Software Testing', 'Computer Science', 5, 4),
(505, 'Natural Language Processing', 'Computer Science', 5, 4),
(601, 'Cyber Security', 'Computer Science', 6, 4),
(602, 'Internet of Things', 'Computer Science', 6, 4),
(603, 'Parallel Computing', 'Computer Science', 6, 4),
(604, 'Big Data Analytics', 'Computer Science', 6, 4),
(605, 'Advanced Algorithms', 'Computer Science', 6, 4),
(701, 'Blockchain Technology', 'Computer Science', 7, 4),
(702, 'Augmented Reality', 'Computer Science', 7, 4),
(703, 'Quantum Computing', 'Computer Science', 7, 4),
(704, 'Deep Learning', 'Computer Science', 7, 4),
(705, 'Ethical Hacking', 'Computer Science', 7, 4),
(801, 'Advanced Database Systems', 'Computer Science', 8, 4),
(802, 'Data Visualization', 'Computer Science', 8, 4),
(803, 'Bioinformatics', 'Computer Science', 8, 4),
(804, 'Advanced Networking', 'Computer Science', 8, 4),
(805, 'Project Management', 'Computer Science', 8, 4),

-- Mechanical Engineering Courses (Semesters 1 to 8)
(111, 'Engineering Mechanics', 'Mechanical Engineering', 1, 4),
(112, 'Engineering Drawing', 'Mechanical Engineering', 1, 4),
(113, 'Thermodynamics', 'Mechanical Engineering', 1, 4),
(114, 'Mathematics I', 'Mechanical Engineering', 1, 4),
(115, 'Physics I', 'Mechanical Engineering', 1, 4),
(211, 'Strength of Materials', 'Mechanical Engineering', 2, 4),
(212, 'Fluid Mechanics', 'Mechanical Engineering', 2, 4),
(213, 'Engineering Materials', 'Mechanical Engineering', 2, 4),
(214, 'Mathematics II', 'Mechanical Engineering', 2, 4),
(215, 'Physics II', 'Mechanical Engineering', 2, 4),
(311, 'Theory of Machines', 'Mechanical Engineering', 3, 4),
(312, 'Heat Transfer', 'Mechanical Engineering', 3, 4),
(313, 'Manufacturing Processes', 'Mechanical Engineering', 3, 4),
(314, 'Mechanical Vibrations', 'Mechanical Engineering', 3, 4),
(315, 'Dynamics of Machines', 'Mechanical Engineering', 3, 4),
(411, 'Design of Machine Elements', 'Mechanical Engineering', 4, 4),
(412, 'Automobile Engineering', 'Mechanical Engineering', 4, 4),
(413, 'Mechatronics', 'Mechanical Engineering', 4, 4),
(414, 'Fluid Power Engineering', 'Mechanical Engineering', 4, 4),
(415, 'Material Science', 'Mechanical Engineering', 4, 4),
(511, 'Robotics', 'Mechanical Engineering', 5, 4),
(512, 'Control Engineering', 'Mechanical Engineering', 5, 4),
(513, 'Industrial Engineering', 'Mechanical Engineering', 5, 4),
(514, 'Refrigeration and Air Conditioning', 'Mechanical Engineering', 5, 4),
(515, 'Machine Tool Engineering', 'Mechanical Engineering', 5, 4),
(611, 'Finite Element Analysis', 'Mechanical Engineering', 6, 4),
(612, 'Power Plant Engineering', 'Mechanical Engineering', 6, 4),
(613, 'Computer-Aided Design', 'Mechanical Engineering', 6, 4),
(614, 'Operations Research', 'Mechanical Engineering', 6, 4),
(615, 'Product Design', 'Mechanical Engineering', 6, 4),
(711, 'Additive Manufacturing', 'Mechanical Engineering', 7, 4),
(712, 'Advanced Fluid Mechanics', 'Mechanical Engineering', 7, 4),
(713, 'Energy Systems Engineering', 'Mechanical Engineering', 7, 4),
(714, 'Machine Learning in Manufacturing', 'Mechanical Engineering', 7, 4),
(715, 'Advanced Control Systems', 'Mechanical Engineering', 7, 4),
(811, 'Sustainable Engineering', 'Mechanical Engineering', 8, 4),
(812, 'Project Management', 'Mechanical Engineering', 8, 4),
(813, 'Supply Chain Management', 'Mechanical Engineering', 8, 4),
(814, 'Smart Manufacturing', 'Mechanical Engineering', 8, 4),
(815, 'Design for Manufacturing', 'Mechanical Engineering', 8, 4);


INSERT INTO Course (CourseID, CourseName, Department, Semester, Credits) VALUES
-- Civil Engineering Courses (Semesters 1 to 8)
(121, 'Engineering Mechanics', 'Civil Engineering', 1, 4),
(122, 'Surveying', 'Civil Engineering', 1, 4),
(123, 'Building Materials', 'Civil Engineering', 1, 4),
(124, 'Mathematics I', 'Civil Engineering', 1, 4),
(125, 'Physics I', 'Civil Engineering', 1, 4),
(221, 'Strength of Materials', 'Civil Engineering', 2, 4),
(222, 'Fluid Mechanics', 'Civil Engineering', 2, 4),
(223, 'Construction Technology', 'Civil Engineering', 2, 4),
(224, 'Mathematics II', 'Civil Engineering', 2, 4),
(225, 'Physics II', 'Civil Engineering', 2, 4),
(321, 'Structural Analysis', 'Civil Engineering', 3, 4),
(322, 'Geotechnical Engineering', 'Civil Engineering', 3, 4),
(323, 'Hydraulics', 'Civil Engineering', 3, 4),
(324, 'Transportation Engineering', 'Civil Engineering', 3, 4),
(325, 'Concrete Technology', 'Civil Engineering', 3, 4),
(421, 'Design of Structures', 'Civil Engineering', 4, 4),
(422, 'Environmental Engineering', 'Civil Engineering', 4, 4),
(423, 'Construction Management', 'Civil Engineering', 4, 4),
(424, 'Bridge Engineering', 'Civil Engineering', 4, 4),
(425, 'Surveying II', 'Civil Engineering', 4, 4),
(521, 'Foundation Engineering', 'Civil Engineering', 5, 4),
(522, 'Irrigation Engineering', 'Civil Engineering', 5, 4),
(523, 'Structural Design', 'Civil Engineering', 5, 4),
(524, 'Transportation Planning', 'Civil Engineering', 5, 4),
(525, 'Water Resources Engineering', 'Civil Engineering', 5, 4),
(621, 'Construction Equipment', 'Civil Engineering', 6, 4),
(622, 'Advanced Structural Analysis', 'Civil Engineering', 6, 4),
(623, 'Building Planning', 'Civil Engineering', 6, 4),
(624, 'Urban Planning', 'Civil Engineering', 6, 4),
(625, 'Disaster Management', 'Civil Engineering', 6, 4),
(721, 'Sustainable Construction', 'Civil Engineering', 7, 4),
(722, 'Advanced Geotechnical Engineering', 'Civil Engineering', 7, 4),
(723, 'Advanced Hydraulics', 'Civil Engineering', 7, 4),
(724, 'Advanced Structural Design', 'Civil Engineering', 7, 4),
(725, 'Smart Cities and Infrastructure', 'Civil Engineering', 7, 4),
(821, 'Environmental Impact Assessment', 'Civil Engineering', 8, 4),
(822, 'Project Management', 'Civil Engineering', 8, 4),
(823, 'Green Building Technology', 'Civil Engineering', 8, 4),
(824, 'Structural Dynamics', 'Civil Engineering', 8, 4),
(825, 'Transport Economics', 'Civil Engineering', 8, 4);


INSERT INTO Course (CourseID, CourseName, Department, Semester, Credits) VALUES
-- Electronics Engineering Courses (Semesters 1 to 8)
(141, 'Basic Electronics', 'Electronics Engineering', 1, 4),
(142, 'Circuit Analysis', 'Electronics Engineering', 1, 4),
(143, 'Mathematics I', 'Electronics Engineering', 1, 4),
(144, 'Physics I', 'Electronics Engineering', 1, 4),
(145, 'Digital Systems', 'Electronics Engineering', 1, 4),
(241, 'Electronic Devices', 'Electronics Engineering', 2, 4),
(242, 'Network Theory', 'Electronics Engineering', 2, 4),
(243, 'Mathematics II', 'Electronics Engineering', 2, 4),
(244, 'Physics II', 'Electronics Engineering', 2, 4),
(245, 'Signals and Systems', 'Electronics Engineering', 2, 4),
(341, 'Analog Electronics', 'Electronics Engineering', 3, 4),
(342, 'Digital Communication', 'Electronics Engineering', 3, 4),
(343, 'Microprocessor Systems', 'Electronics Engineering', 3, 4),
(344, 'Electromagnetic Fields', 'Electronics Engineering', 3, 4),
(345, 'Control Systems', 'Electronics Engineering', 3, 4),
(441, 'VLSI Design', 'Electronics Engineering', 4, 4),
(442, 'Microcontroller Applications', 'Electronics Engineering', 4, 4),
(443, 'Digital Signal Processing', 'Electronics Engineering', 4, 4),
(444, 'Power Electronics', 'Electronics Engineering', 4, 4),
(445, 'Communication Systems', 'Electronics Engineering', 4, 4),
(541, 'Embedded Systems', 'Electronics Engineering', 5, 4),
(542, 'Optoelectronics', 'Electronics Engineering', 5, 4),
(543, 'Nanoelectronics', 'Electronics Engineering', 5, 4),
(544, 'Advanced VLSI Design', 'Electronics Engineering', 5, 4),
(545, 'Robotics and Automation', 'Electronics Engineering', 5, 4),
(641, 'Wireless Communication', 'Electronics Engineering', 6, 4),
(642, 'Advanced Microcontrollers', 'Electronics Engineering', 6, 4),
(643, 'Computer Networks', 'Electronics Engineering', 6, 4),
(644, 'Sensors and Actuators', 'Electronics Engineering', 6, 4),
(645, 'Digital Image Processing', 'Electronics Engineering', 6, 4),
(741, 'Signal Processing for 5G', 'Electronics Engineering', 7, 4),
(742, 'Quantum Electronics', 'Electronics Engineering', 7, 4),
(743, 'Advanced Communication Systems', 'Electronics Engineering', 7, 4),
(744, 'IoT Systems Design', 'Electronics Engineering', 7, 4),
(745, 'Machine Learning for Electronics', 'Electronics Engineering', 7, 4),
(841, 'AI in Signal Processing', 'Electronics Engineering', 8, 4),
(842, 'Cryptography and Security', 'Electronics Engineering', 8, 4),
(843, 'Project Management', 'Electronics Engineering', 8, 4),
(844, 'Advanced Robotics', 'Electronics Engineering', 8, 4),
(845, 'Advanced Antenna Design', 'Electronics Engineering', 8, 4);


INSERT INTO Course (CourseID, CourseName, Department, Semester, Credits) VALUES
-- Electrical Engineering Courses (Semesters 1 to 8)
(131, 'Circuit Theory', 'Electrical Engineering', 1, 4),
(132, 'Electromagnetic Fields', 'Electrical Engineering', 1, 4),
(133, 'Mathematics I', 'Electrical Engineering', 1, 4),
(134, 'Physics I', 'Electrical Engineering', 1, 4),
(135, 'Digital Logic', 'Electrical Engineering', 1, 4),
(231, 'Network Analysis', 'Electrical Engineering', 2, 4),
(232, 'Signals and Systems', 'Electrical Engineering', 2, 4),
(233, 'Mathematics II', 'Electrical Engineering', 2, 4),
(234, 'Physics II', 'Electrical Engineering', 2, 4),
(235, 'Analog Electronics', 'Electrical Engineering', 2, 4),
(331, 'Power Systems I', 'Electrical Engineering', 3, 4),
(332, 'Control Systems', 'Electrical Engineering', 3, 4),
(333, 'Electrical Machines I', 'Electrical Engineering', 3, 4),
(334, 'Microprocessors', 'Electrical Engineering', 3, 4),
(335, 'Digital Signal Processing', 'Electrical Engineering', 3, 4),
(431, 'Power Systems II', 'Electrical Engineering', 4, 4),
(432, 'Electrical Machines II', 'Electrical Engineering', 4, 4),
(433, 'Power Electronics', 'Electrical Engineering', 4, 4),
(434, 'Renewable Energy Systems', 'Electrical Engineering', 4, 4),
(435, 'Communication Systems', 'Electrical Engineering', 4, 4),
(531, 'High Voltage Engineering', 'Electrical Engineering', 5, 4),
(532, 'Electrical Drives', 'Electrical Engineering', 5, 4),
(533, 'Advanced Control Systems', 'Electrical Engineering', 5, 4),
(534, 'Smart Grid Technologies', 'Electrical Engineering', 5, 4),
(535, 'Instrumentation', 'Electrical Engineering', 5, 4),
(631, 'Advanced Power Systems', 'Electrical Engineering', 6, 4),
(632, 'VLSI Design', 'Electrical Engineering', 6, 4),
(633, 'Embedded Systems', 'Electrical Engineering', 6, 4),
(634, 'Electric Vehicle Technology', 'Electrical Engineering', 6, 4),
(635, 'Energy Management', 'Electrical Engineering', 6, 4),
(731, 'Artificial Intelligence in Power Systems', 'Electrical Engineering', 7, 4),
(732, 'Power System Protection', 'Electrical Engineering', 7, 4),
(733, 'Advanced Power Electronics', 'Electrical Engineering', 7, 4),
(734, 'Renewable Energy Grid Integration', 'Electrical Engineering', 7, 4),
(735, 'Smart Grid Security', 'Electrical Engineering', 7, 4),
(831, 'Power System Stability', 'Electrical Engineering', 8, 4),
(832, 'Electric Power Market Operations', 'Electrical Engineering', 8, 4),
(833, 'Smart Energy Systems', 'Electrical Engineering', 8, 4),
(834, 'Advanced Electric Drives', 'Electrical Engineering', 8, 4),
(835, 'Power Systems Optimization', 'Electrical Engineering', 8, 4);


-- result
CREATE TABLE Result (
    StudentID INT NOT NULL,   
    Course1 VARCHAR(2) NOT NULL,  
    Course2 VARCHAR(2) NOT NULL,  
    Course3 VARCHAR(2) NOT NULL,
    Course4 VARCHAR(2) NOT NULL, 
    Course5 VARCHAR(2) NOT NULL ,
    totalcredit decimal(7,2)
);
drop table result;
INSERT INTO Result (StudentID, Course1, Course2, Course3, Course4, Course5) VALUES
-- Students from 2101 to 2110
(2101, 'A', 'B', 'C', 'A', 'B'),
(2102, 'B', 'B', 'A', 'A', 'C'),
(2103, 'A', 'C', 'B', 'B', 'A'),
(2104, 'C', 'B', 'A', 'A', 'B'),
(2105, 'B', 'A', 'C', 'B', 'A'),
(2106, 'A', 'A', 'B', 'C', 'C'),
(2107, 'B', 'C', 'B', 'A', 'A'),
(2108, 'A', 'B', 'C', 'A', 'C'),
(2109, 'C', 'A', 'B', 'B', 'A'),
(2110, 'B', 'C', 'A', 'A', 'B'),
-- Students from 2111 to 2120
(2111, 'A', 'B', 'C', 'A', 'B'),
(2112, 'B', 'A', 'A', 'B', 'C'),
(2113, 'C', 'B', 'C', 'A', 'B'),
(2114, 'B', 'C', 'B', 'A', 'A'),
(2115, 'A', 'A', 'C', 'B', 'A'),
(2116, 'B', 'B', 'A', 'C', 'C'),
(2117, 'C', 'A', 'B', 'B', 'A'),
(2118, 'A', 'C', 'B', 'A', 'B'),
(2119, 'C', 'A', 'B', 'B', 'C'),
(2120, 'B', 'C', 'A', 'A', 'B'),
-- Students from 2201 to 2210
(2201, 'A', 'B', 'C', 'B', 'A'),
(2202, 'B', 'C', 'B', 'A', 'B'),
(2203, 'C', 'A', 'B', 'A', 'C'),
(2204, 'B', 'B', 'A', 'C', 'B'),
(2205, 'A', 'C', 'B', 'A', 'B'),
(2206, 'B', 'A', 'A', 'B', 'C'),
(2207, 'C', 'B', 'C', 'A', 'B'),
(2208, 'B', 'A', 'B', 'C', 'A'),
(2209, 'A', 'C', 'A', 'B', 'B'),
(2210, 'B', 'B', 'C', 'A', 'C'),
-- Students from 2211 to 2220
(2211, 'A', 'B', 'A', 'A', 'B'),
(2212, 'C', 'A', 'B', 'B', 'A'),
(2213, 'B', 'C', 'C', 'A', 'B'),
(2214, 'A', 'A', 'B', 'B', 'C'),
(2215, 'C', 'B', 'A', 'A', 'B'),
(2216, 'B', 'C', 'B', 'A', 'C'),
(2217, 'A', 'B', 'C', 'C', 'A'),
(2218, 'B', 'A', 'B', 'A', 'B'),
(2219, 'C', 'B', 'A', 'B', 'C'),
(2220, 'B', 'A', 'C', 'B', 'A'),
-- Students from 2301 to 2310
(2301, 'A', 'C', 'B', 'B', 'A'),
(2302, 'B', 'B', 'A', 'C', 'B'),
(2303, 'C', 'A', 'C', 'A', 'B'),
(2304, 'B', 'C', 'B', 'A', 'A'),
(2305, 'A', 'B', 'A', 'B', 'C'),
(2306, 'B', 'A', 'C', 'B', 'A'),
(2307, 'C', 'C', 'B', 'A', 'B'),
(2308, 'B', 'A', 'A', 'C', 'A'),
(2309, 'A', 'B', 'C', 'B', 'B'),
(2310, 'B', 'C', 'A', 'A', 'C'),

(2311, 'A', 'A', 'C', 'B', 'A'),
(2312, 'B', 'C', 'B', 'A', 'B'),
(2313, 'C', 'B', 'A', 'C', 'A'),(2314,'A','B','C','F','F'),
(2315, 'A', 'B', 'B', 'C', 'A'),(2316, 'C', 'A', 'B', 'A', 'B'),(2317, 'B', 'B', 'A', 'C', 'B'),(2318, 'A', 'C', 'B', 'A', 'A'),(2319, 'B', 'A', 'C', 'B', 'C'),(2320, 'C', 'B', 'B', 'A', 'B'),
(2401, 'A', 'C', 'B', 'A', 'B'),(2402, 'B', 'B', 'A', 'C', 'A'),(2403, 'C', 'A', 'B', 'B', 'C'),(2404, 'B', 'C', 'A', 'A', 'B'),(2405, 'A', 'B', 'B', 'C', 'A'),(2406, 'C', 'A', 'C', 'B', 'B'),(2407, 'B', 'B', 'A', 'A', 'C'),(2408, 'A', 'C', 'B', 'C', 'A'),(2409, 'C', 'A', 'B', 'B', 'A'),(2410, 'B', 'C', 'A', 'A', 'B'),
(2411, 'A', 'B', 'C', 'A', 'B'),(2412, 'C', 'A', 'B', 'B', 'A'),(2413, 'B', 'C', 'A', 'A', 'C'),(2414, 'A', 'B', 'C', 'B', 'A'),(2415, 'C', 'A', 'B', 'C', 'B'),(2416, 'B', 'A', 'C', 'A', 'B'),(2417, 'A', 'B', 'A', 'B', 'C'),(2418, 'C', 'A', 'B', 'C', 'A'),(2419, 'B', 'B', 'A', 'A', 'B'),(2420, 'A', 'C', 'B', 'C', 'A');
UPDATE Result
SET totalcredit = 310
WHERE StudentID BETWEEN 2301 AND 2310;
SET SQL_SAFE_UPDATES = 0;


CREATE TABLE Professor (
    ProfessorID INT PRIMARY KEY ,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(100)
);
-- Data
INSERT INTO Professor (ProfessorID, Name, Email) VALUES
(1, 'Dr. Aditi Sharma', 'aditi.sharma@university.edu'),
(2, 'Prof. Rajesh Kumar', 'rajesh.kumar@university.edu'),
(3, 'Dr. Neha Singh', 'neha.singh@university.edu'),
(4, 'Prof. Anil Verma', 'anil.verma@university.edu'),
(5, 'Dr. Priya Iyer', 'priya.iyer@university.edu'),
(6, 'Prof. Arvind Gupta', 'arvind.gupta@university.edu'),
(7, 'Dr. Meera Reddy', 'meera.reddy@university.edu'),
(8, 'Prof. Sameer Joshi', 'sameer.joshi@university.edu'),
(9, 'Dr. Kavita Bansal', 'kavita.bansal@university.edu'),
(10, 'Prof. Ravi Mehta', 'ravi.mehta@university.edu'),
(11, 'Dr. Suresh Nair', 'suresh.nair@university.edu'),
(12, 'Prof. Anita Rao', 'anita.rao@university.edu'),
(13, 'Dr. Sanjay Choudhary', 'sanjay.choudhary@university.edu'),
(14, 'Prof. Deepa Desai', 'deepa.desai@university.edu'),
(15, 'Dr. Vikram Pillai', 'vikram.pillai@university.edu'),
(16, 'Prof. Nisha Kapoor', 'nisha.kapoor@university.edu'),
(17, 'Dr. Ramesh Joshi', 'ramesh.joshi@university.edu'),
(18, 'Prof. Pooja Agarwal', 'pooja.agarwal@university.edu'),
(19, 'Dr. Alok Mishra', 'alok.mishra@university.edu'),
(20, 'Prof. Suman Ghosh', 'suman.ghosh@university.edu');


-- on delete cascade
create table professorcourse(
  ProfessorID INT,
    CourseID int
  
);
drop table professorcourse;
INSERT INTO PROFESSORCOURse (ProfessorID, CourseID)
VALUES
(1, '101'), (1, '102'), (1, '103'), (1, '104'), (1, '105'), (1, '111'), (1, '112'), (1, '113'), (1, '114'), (1, '115'),
(2, '121'), (2, '122'), (2, '123'), (2, '124'), (2, '125'), (2, '131'), (2, '132'), (2, '133'), (2, '134'), (2, '135'),
(3, '141'), (3, '142'), (3, '143'), (3, '144'), (3, '145'), (3, '201'), (3, '202'), (3, '203'), (3, '204'), (3, '205'),
(4, '211'), (4, '212'), (4, '213'), (4, '214'), (4, '215'), (4, '221'), (4, '222'), (4, '223'), (4, '224'), (4, '225'),
(5, '231'), (5, '232'), (5, '233'), (5, '234'), (5, '235'), (5, '241'), (5, '242'), (5, '243'), (5, '244'), (5, '245'),
(6, '301'), (6, '302'), (6, '303'), (6, '304'), (6, '305'), (6, '311'), (6, '312'), (6, '313'), (6, '314'), (6, '315'),
(7, '321'), (7, '322'), (7, '323'), (7, '324'), (7, '325'), (7, '331'), (7, '332'), (7, '333'), (7, '334'), (7, '335'),
(8, '341'), (8, '342'), (8, '343'), (8, '344'), (8, '345'), (8, '401'), (8, '402'), (8, '403'), (8, '404'), (8, '405'),
(9, '411'), (9, '412'), (9, '413'), (9, '414'), (9, '415'), (9, '421'), (9, '422'), (9, '423'), (9, '424'), (9, '425'),
(10, '431'), (10, '432'), (10, '433'), (10, '434'), (10, '435'), (10, '441'), (10, '442'), (10, '443'), (10, '444'), (10, '445'),
(11, '501'), (11, '502'), (11, '503'), (11, '504'), (11, '505'), (11, '511'), (11, '512'), (11, '513'), (11, '514'), (11, '515'),
(12, '521'), (12, '522'), (12, '523'), (12, '524'), (12, '525'), (12, '531'), (12, '532'), (12, '533'), (12, '534'), (12, '535'),
(13, '541'), (13, '542'), (13, '543'), (13, '544'), (13, '545'), (13, '601'), (13, '602'), (13, '603'), (13, '604'), (13, '605'),
(14, '611'), (14, '612'), (14, '613'), (14, '614'), (14, '615'), (14, '621'), (14, '622'), (14, '623'), (14, '624'), (14, '625'),
(15, '631'), (15, '632'), (15, '633'), (15, '634'), (15, '635'), (15, '641'), (15, '642'), (15, '643'), (15, '644'), (15, '645'),
(16, '701'), (16, '702'), (16, '703'), (16, '704'), (16, '705'), (16, '711'), (16, '712'), (16, '713'), (16, '714'), (16, '715'),
(17, '721'), (17, '722'), (17, '723'), (17, '724'), (17, '725'), (17, '731'), (17, '732'), (17, '733'), (17, '734'), (17, '735'),
(18, '741'), (18, '742'), (18, '743'), (18, '744'), (18, '745'), (18, '801'), (18, '802'), (18, '803'), (18, '804'), (18, '805'),
(19, '811'), (19, '812'), (19, '813'), (19, '814'), (19, '815'), (19, '821'), (19, '822'), (19, '823'), (19, '824'), (19, '825'),
(20, '831'), (20, '832'), (20, '833'), (20, '834'), (20, '835'), (20, '841'), (20, '842'), (20, '843'), (20, '844'), (20, '845');

select courseid from course;
use assignment8;
CREATE TABLE SCHEDULE (
     CourseID INT,
    Department VARCHAR(50),
    RoomNo VARCHAR(10),
    Timing VARCHAR(50)
    
);
drop table schedule;
-- Schedule for Semester 1
INSERT INTO SCHEDULE (CourseID, Department, RoomNo, Timing) 
VALUES 
-- Computer Science Courses
(101, 'Computer Science', 'Room 101', '9:00 AM - 10:30 AM'),
(102, 'Computer Science', 'Room 102', '10:30 AM - 12:00 PM'),
(103, 'Computer Science', 'Room 103', '1:00 PM - 2:30 PM'),
(104, 'Computer Science', 'Room 104', '2:30 PM - 4:00 PM'),
(105, 'Computer Science', 'Room 105', '4:00 PM - 5:30 PM'),
(201, 'Computer Science', 'Room 201', '9:00 AM - 10:30 AM'),
(202, 'Computer Science', 'Room 202', '10:30 AM - 12:00 PM'),
(203, 'Computer Science', 'Room 203', '1:00 PM - 2:30 PM'),
(204, 'Computer Science', 'Room 204', '2:30 PM - 4:00 PM'),
(205, 'Computer Science', 'Room 205', '4:00 PM - 5:30 PM'),
(301, 'Computer Science', 'Room 301', '9:00 AM - 10:30 AM'),
(302, 'Computer Science', 'Room 302', '10:30 AM - 12:00 PM'),
(303, 'Computer Science', 'Room 303', '1:00 PM - 2:30 PM'),
(304, 'Computer Science', 'Room 304', '2:30 PM - 4:00 PM'),
(305, 'Computer Science', 'Room 305', '4:00 PM - 5:30 PM'),
(401, 'Computer Science', 'Room 401', '9:00 AM - 10:30 AM'),
(402, 'Computer Science', 'Room 402', '10:30 AM - 12:00 PM'),
(403, 'Computer Science', 'Room 403', '1:00 PM - 2:30 PM'),
(404, 'Computer Science', 'Room 404', '2:30 PM - 4:00 PM'),
(405, 'Computer Science', 'Room 405', '4:00 PM - 5:30 PM'),
(501, 'Computer Science', 'Room 501', '9:00 AM - 10:30 AM'),
(502, 'Computer Science', 'Room 502', '10:30 AM - 12:00 PM'),
(503, 'Computer Science', 'Room 503', '1:00 PM - 2:30 PM'),
(504, 'Computer Science', 'Room 504', '2:30 PM - 4:00 PM'),
(505, 'Computer Science', 'Room 505', '4:00 PM - 5:30 PM'),
(601, 'Computer Science', 'Room 601', '9:00 AM - 10:30 AM'),
(602, 'Computer Science', 'Room 602', '10:30 AM - 12:00 PM'),
(603, 'Computer Science', 'Room 603', '1:00 PM - 2:30 PM'),
(604, 'Computer Science', 'Room 604', '2:30 PM - 4:00 PM'),
(605, 'Computer Science', 'Room 605', '4:00 PM - 5:30 PM'),
(701, 'Computer Science', 'Room 701', '9:00 AM - 10:30 AM'),
(702, 'Computer Science', 'Room 702', '10:30 AM - 12:00 PM'),
(703, 'Computer Science', 'Room 703', '1:00 PM - 2:30 PM'),
(704, 'Computer Science', 'Room 704', '2:30 PM - 4:00 PM'),
(705, 'Computer Science', 'Room 705', '4:00 PM - 5:30 PM'),
(801, 'Computer Science', 'Room 801', '9:00 AM - 10:30 AM'),
(802, 'Computer Science', 'Room 802', '10:30 AM - 12:00 PM'),
(803, 'Computer Science', 'Room 803', '1:00 PM - 2:30 PM'),
(804, 'Computer Science', 'Room 804', '2:30 PM - 4:00 PM'),
(805, 'Computer Science', 'Room 805', '4:00 PM - 5:30 PM'),
-- Mechanical Engineering Courses
(111, 'Mechanical Engineering', 'Room 111', '9:00 AM - 10:30 AM'),
(112, 'Mechanical Engineering', 'Room 112', '10:30 AM - 12:00 PM'),
(113, 'Mechanical Engineering', 'Room 113', '1:00 PM - 2:30 PM'),
(114, 'Mechanical Engineering', 'Room 114', '2:30 PM - 4:00 PM'),
(115, 'Mechanical Engineering', 'Room 115', '4:00 PM - 5:30 PM'),
(211, 'Mechanical Engineering', 'Room 211', '9:00 AM - 10:30 AM'),
(212, 'Mechanical Engineering', 'Room 212', '10:30 AM - 12:00 PM'),
(213, 'Mechanical Engineering', 'Room 213', '1:00 PM - 2:30 PM'),
(214, 'Mechanical Engineering', 'Room 214', '2:30 PM - 4:00 PM'),
(215, 'Mechanical Engineering', 'Room 215', '4:00 PM - 5:30 PM'),
(311, 'Mechanical Engineering', 'Room 311', '9:00 AM - 10:30 AM'),
(312, 'Mechanical Engineering', 'Room 312', '10:30 AM - 12:00 PM'),
(313, 'Mechanical Engineering', 'Room 313', '1:00 PM - 2:30 PM'),
(314, 'Mechanical Engineering', 'Room 314', '2:30 PM - 4:00 PM'),
(315, 'Mechanical Engineering', 'Room 315', '4:00 PM - 5:30 PM'),
(411, 'Mechanical Engineering', 'Room 411', '9:00 AM - 10:30 AM'),
(412, 'Mechanical Engineering', 'Room 412', '10:30 AM - 12:00 PM'),
(413, 'Mechanical Engineering', 'Room 413', '1:00 PM - 2:30 PM'),
(414, 'Mechanical Engineering', 'Room 414', '2:30 PM - 4:00 PM'),
(415, 'Mechanical Engineering', 'Room 415', '4:00 PM - 5:30 PM'),
(511, 'Mechanical Engineering', 'Room 511', '9:00 AM - 10:30 AM'),
(512, 'Mechanical Engineering', 'Room 512', '10:30 AM - 12:00 PM'),
(513, 'Mechanical Engineering', 'Room 513', '1:00 PM - 2:30 PM'),
(514, 'Mechanical Engineering', 'Room 514', '2:30 PM - 4:00 PM'),
(515, 'Mechanical Engineering', 'Room 515', '4:00 PM - 5:30 PM'),
(611, 'Mechanical Engineering', 'Room 611', '9:00 AM - 10:30 AM'),
(612, 'Mechanical Engineering', 'Room 612', '10:30 AM - 12:00 PM'),
(613, 'Mechanical Engineering', 'Room 613', '1:00 PM - 2:30 PM'),
(614, 'Mechanical Engineering', 'Room 614', '2:30 PM - 4:00 PM'),
(615, 'Mechanical Engineering', 'Room 615', '4:00 PM - 5:30 PM'),
(711, 'Mechanical Engineering', 'Room 711', '9:00 AM - 10:30 AM'),
(712, 'Mechanical Engineering', 'Room 712', '10:30 AM - 12:00 PM'),
(713, 'Mechanical Engineering', 'Room 713', '1:00 PM - 2:30 PM'),
(714, 'Mechanical Engineering', 'Room 714', '2:30 PM - 4:00 PM'),
(715, 'Mechanical Engineering', 'Room 715', '4:00 PM - 5:30 PM'),
(811, 'Mechanical Engineering', 'Room 811', '9:00 AM - 10:30 AM'),
(812, 'Mechanical Engineering', 'Room 812', '10:30 AM - 12:00 PM'),
(813, 'Mechanical Engineering', 'Room 813', '1:00 PM - 2:30 PM'),
(814, 'Mechanical Engineering', 'Room 814', '2:30 PM - 4:00 PM'),
(815, 'Mechanical Engineering', 'Room 815', '4:00 PM - 5:00 pm'),
-- Civil Engineering Courses
(121, 'Civil Engineering', 'Room 121', '9:00 AM - 10:30 AM'),
(122, 'Civil Engineering', 'Room 122', '10:30 AM - 12:00 PM'),
(123, 'Civil Engineering', 'Room 123', '1:00 PM - 2:30 PM'),
(124, 'Civil Engineering', 'Room 124', '2:30 PM - 4:00 PM'),
(125, 'Civil Engineering', 'Room 125', '4:00 PM - 5:30 PM'),
(221, 'Civil Engineering', 'Room 221', '9:00 AM - 10:30 AM'),
(222, 'Civil Engineering', 'Room 222', '10:30 AM - 12:00 PM'),
(223, 'Civil Engineering', 'Room 223', '1:00 PM - 2:30 PM'),
(224, 'Civil Engineering', 'Room 224', '2:30 PM - 4:00 PM'),
(225, 'Civil Engineering', 'Room 225', '4:00 PM - 5:30 PM'),
(321, 'Civil Engineering', 'Room 321', '9:00 AM - 10:30 AM'),
(322, 'Civil Engineering', 'Room 322', '10:30 AM - 12:00 PM'),
(323, 'Civil Engineering', 'Room 323', '1:00 PM - 2:30 PM'),
(324, 'Civil Engineering', 'Room 324', '2:30 PM - 4:00 PM'),
(325, 'Civil Engineering', 'Room 325', '4:00 PM - 5:30 PM'),
(421, 'Civil Engineering', 'Room 421', '9:00 AM - 10:30 AM'),
(422, 'Civil Engineering', 'Room 422', '10:30 AM - 12:00 PM'),
(423, 'Civil Engineering', 'Room 423', '1:00 PM - 2:30 PM'),
(424, 'Civil Engineering', 'Room 424', '2:30 PM - 4:00 PM'),
(425, 'Civil Engineering', 'Room 425', '4:00 PM - 5:30 PM'),
(521, 'Civil Engineering', 'Room 521', '9:00 AM - 10:30 AM'),
(522, 'Civil Engineering', 'Room 522', '10:30 AM - 12:00 PM'),
(523, 'Civil Engineering', 'Room 523', '1:00 PM - 2:30 PM'),
(524, 'Civil Engineering', 'Room 524', '2:30 PM - 4:00 PM'),
(525, 'Civil Engineering', 'Room 525', '4:00 PM - 5:30 PM'),
(621, 'Civil Engineering', 'Room 621', '9:00 AM - 10:30 AM'),
(622, 'Civil Engineering', 'Room 622', '10:30 AM - 12:00 PM'),
(623, 'Civil Engineering', 'Room 623', '1:00 PM - 2:30 PM'),
(624, 'Civil Engineering', 'Room 624', '2:30 PM - 4:00 PM'),
(625, 'Civil Engineering', 'Room 625', '4:00 PM - 5:30 PM'),
(721, 'Civil Engineering', 'Room 721', '9:00 AM - 10:30 AM'),
(722, 'Civil Engineering', 'Room 722', '10:30 AM - 12:00 PM'),
(723, 'Civil Engineering', 'Room 723', '1:00 PM - 2:30 PM'),
(724, 'Civil Engineering', 'Room 724', '2:30 PM - 4:00 PM'),
(725, 'Civil Engineering', 'Room 725', '4:00 PM - 5:30 PM'),
(821, 'Civil Engineering', 'Room 821', '9:00 AM - 10:30 AM'),
(822, 'Civil Engineering', 'Room 822', '10:30 AM - 12:00 PM'),
(823, 'Civil Engineering', 'Room 823', '1:00 PM - 2:30 PM'),
(824, 'Civil Engineering', 'Room 824', '2:30 PM - 4:00 PM'),
(825, 'Civil Engineering', 'Room 825', '4:00 PM - 5:30 PM'),
-- Electrical Engineering Courses
(131, 'Electrical Engineering', 'Room 131', '9:00 AM - 10:30 AM'),
(132, 'Electrical Engineering', 'Room 132', '10:30 AM - 12:00 PM'),
(133, 'Electrical Engineering', 'Room 133', '1:00 PM - 2:30 PM'),
(134, 'Electrical Engineering', 'Room 134', '2:30 PM - 4:00 PM'),
(135, 'Electrical Engineering', 'Room 135', '4:00 PM - 5:30 PM'),
(231, 'Electrical Engineering', 'Room 231', '9:00 AM - 10:30 AM'),
(232, 'Electrical Engineering', 'Room 232', '10:30 AM - 12:00 PM'),
(233, 'Electrical Engineering', 'Room 233', '1:00 PM - 2:30 PM'),
(234, 'Electrical Engineering', 'Room 234', '2:30 PM - 4:00 PM'),
(235, 'Electrical Engineering', 'Room 235', '4:00 PM - 5:30 PM'),
(331, 'Electrical Engineering', 'Room 331', '9:00 AM - 10:30 AM'),
(332, 'Electrical Engineering', 'Room 332', '10:30 AM - 12:00 PM'),
(333, 'Electrical Engineering', 'Room 333', '1:00 PM - 2:30 PM'),
(334, 'Electrical Engineering', 'Room 334', '2:30 PM - 4:00 PM'),
(335, 'Electrical Engineering', 'Room 335', '4:00 PM - 5:30 PM'),
(431, 'Electrical Engineering', 'Room 431', '9:00 AM - 10:30 AM'),
(432, 'Electrical Engineering', 'Room 432', '10:30 AM - 12:00 PM'),
(433, 'Electrical Engineering', 'Room 433', '1:00 PM - 2:30 PM'),
(434, 'Electrical Engineering', 'Room 434', '2:30 PM - 4:00 PM'),
(435, 'Electrical Engineering', 'Room 435', '4:00 PM - 5:30 PM'),
(531, 'Electrical Engineering', 'Room 531', '9:00 AM - 10:30 AM'),
(532, 'Electrical Engineering', 'Room 532', '10:30 AM - 12:00 PM'),
(533, 'Electrical Engineering', 'Room 533', '1:00 PM - 2:30 PM'),
(534, 'Electrical Engineering', 'Room 534', '2:30 PM - 4:00 PM'),
(535, 'Electrical Engineering', 'Room 535', '4:00 PM - 5:30 PM'),
(631, 'Electrical Engineering', 'Room 631', '9:00 AM - 10:30 AM'),
(632, 'Electrical Engineering', 'Room 632', '10:30 AM - 12:00 PM'),
(633, 'Electrical Engineering', 'Room 633', '1:00 PM - 2:30 PM'),
(634, 'Electrical Engineering', 'Room 634', '2:30 PM - 4:00 PM'),
(635, 'Electrical Engineering', 'Room 635', '4:00 PM - 5:30 PM'),
(731, 'Electrical Engineering', 'Room 731', '9:00 AM - 10:30 AM'),
(732, 'Electrical Engineering', 'Room 732', '10:30 AM - 12:00 PM'),
(733, 'Electrical Engineering', 'Room 733', '1:00 PM - 2:30 PM'),
(734, 'Electrical Engineering', 'Room 734', '2:30 PM - 4:00 PM'),
(735, 'Electrical Engineering', 'Room 735', '4:00 PM - 5:30 PM'),
(831, 'Electrical Engineering', 'Room 831', '9:00 AM - 10:30 AM'),
(832, 'Electrical Engineering', 'Room 832', '10:30 AM - 12:00 PM'),
(833, 'Electrical Engineering', 'Room 833', '1:00 PM - 2:30 PM'),
(834, 'Electrical Engineering', 'Room 834', '2:30 PM - 4:00 PM'),
(835, 'Electrical Engineering', 'Room 835', '4:00 pm-5:00pm'), 
(141, 'Electronic Engineering', 'Room 141 ', '9:00 AM - 10:30 AM'),
(142, 'Electronic Engineering', 'Room 142', '10:30 AM - 12:00 PM'),
(143, 'Electronic Engineering', 'Room 143', '1:00 PM - 2:30 PM'),
(144, 'Electronic Engineering', 'Room 144', '2:30 PM - 4:00 PM'),
(145, 'Electronic Engineering', 'Room 145', '4:00 PM - 5:30 PM'),
(241, 'Electronic Engineering', 'Room 231', '9:00 AM - 10:30 AM'),
(242, 'Electronic Engineering', 'Room 232', '10:30 AM - 12:00 PM'),
(243, 'Electronic Engineering', 'Room 233', '1:00 PM - 2:30 PM'),
(244, 'Electronic Engineering', 'Room 234', '2:30 PM - 4:00 PM'),
(245, 'Electronic Engineering', 'Room 235', '4:00 PM - 5:30 PM'),
(341, 'Electronic Engineering', 'Room 331', '9:00 AM - 10:30 AM'),
(342, 'Electronic Engineering', 'Room 332', '10:30 AM - 12:00 PM'),
(343, 'Electronic Engineering', 'Room 333', '1:00 PM - 2:30 PM'),
(344, 'Electronic Engineering', 'Room 334', '2:30 PM - 4:00 PM'),
(345, 'Electronic Engineering', 'Room 335', '4:00 PM - 5:30 PM'),
(441, 'Electronic Engineering', 'Room 431', '9:00 AM - 10:30 AM'),
(442, 'Electronic Engineering', 'Room 432', '10:30 AM - 12:00 PM'),
(443, 'Electronic Engineering', 'Room 433', '1:00 PM - 2:30 PM'),
(444, 'Electronic Engineering', 'Room 434', '2:30 PM - 4:00 PM'),
(445, 'Electronic Engineering', 'Room 435', '4:00 PM - 5:30 PM'),
(541, 'Electronic Engineering', 'Room 531', '9:00 AM - 10:30 AM'),
(542, 'Electronic Engineering', 'Room 532', '10:30 AM - 12:00 PM'),
(543, 'Electronic Engineering', 'Room 533', '1:00 PM - 2:30 PM'),
(544, 'Electronic Engineering', 'Room 534', '2:30 PM - 4:00 PM'),
(545, 'Electronic Engineering', 'Room 535', '4:00 PM - 5:30 PM'),
(641, 'Electronic Engineering', 'Room 631', '9:00 AM - 10:30 AM'),
(642, 'Electronic Engineering', 'Room 632', '10:30 AM - 12:00 PM'),
(643, 'Electronic Engineering', 'Room 633', '1:00 PM - 2:30 PM'),
(644, 'Electronic Engineering', 'Room 634', '2:30 PM - 4:00 PM'),
(645, 'Electronic Engineering', 'Room 635', '4:00 PM - 5:30 PM'),
(741, 'Electronic Engineering', 'Room 731', '9:00 AM - 10:30 AM'),
(742, 'Electronic Engineering', 'Room 732', '10:30 AM - 12:00 PM'),
(743, 'Electronic Engineering', 'Room 733', '1:00 PM - 2:30 PM'),
(744, 'Electronic Engineering', 'Room 734', '2:30 PM - 4:00 PM'),
(745, 'Electronic Engineering', 'Room 735', '4:00 PM - 5:30 PM'),
(841, 'Electronic Engineering', 'Room 831', '9:00 AM - 10:30 AM'),
(842, 'Electronic Engineering', 'Room 832', '10:30 AM - 12:00 PM'),
(843, 'Electronic Engineering', 'Room 833', '1:00 PM - 2:30 PM'),
(844, 'Electronic Engineering', 'Room 834', '2:30 PM - 4:00 PM'),
(845, 'Electronic Engineering', 'Room 835', '4:00 PM - 5:30 PM');

create table inquiry(
 studentid int,
 quer varchar(500),
 status varchar(20) default 'pending'
);
-- drop table inquiry;
-- select * from inquiry;
--  SELECT p.Name AS ProfessorName,s.Timing,s.RoomNo,c.CourseName FROM SCHEDULE s natural JOIN ProfessorCourse pc natural JOIN Professor p natural JOIN Course c WHERE c.Semester = 2 AND c.Department = 'Electronics Engineering'; 
--  
-- select * from inquiry;
-- update schedule set Department='Electronics Engineering' where department='Electronic Engineering';
-- use assignment8;
-- ALTER TABLE course
-- ADD pre varchar(20);
-- SET SQL_SAFE_UPDATES = 0;

-- update course set pre='PrevSemSyllabus';
-- select * from course;



-- SELECT  distinct s.StudentID, s.Name, s.Department, s.Semester, s.Email
-- FROM Students s
-- JOIN Course c ON s.Department = c.Department AND s.Semester = c.Semester
-- JOIN PROFESSORCOURse pc ON c.CourseID = pc.CourseID
-- WHERE pc.ProfessorID = 1;

-- update students set reg=1;
select * from course where courseid=201;