-- Drop tables if they exist (for idempotency)
DROP TABLE IF EXISTS Bill;
DROP TABLE IF EXISTS Appointment;
DROP TABLE IF EXISTS Surgery;
DROP TABLE IF EXISTS Patient;
DROP TABLE IF EXISTS Dentist;

-- Create Dentist Table
CREATE TABLE Dentist (
    dentistId INT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    phone VARCHAR(15),
    email VARCHAR(100),
    specialization VARCHAR(100)
);

-- Create Patient Table
CREATE TABLE Patient (
    patientId INT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    phone VARCHAR(15),
    email VARCHAR(100),
    mailingAddress VARCHAR(200),
    dob DATE,
    billingStatus BOOLEAN DEFAULT FALSE  -- FALSE indicates no outstanding bill
);

-- Create Surgery Table
CREATE TABLE Surgery (
    surgeryId INT PRIMARY KEY,
    name VARCHAR(100),
    address VARCHAR(200),
    phone VARCHAR(15)
);

-- Create Appointment Table
CREATE TABLE Appointment (
    appointmentId INT PRIMARY KEY,
    appointmentDate DATE,
    appointmentTime TIME,
    status VARCHAR(20),
    dentistId INT,
    patientId INT,
    surgeryId INT,
    FOREIGN KEY (dentistId) REFERENCES Dentist(dentistId),
    FOREIGN KEY (patientId) REFERENCES Patient(patientId),
    FOREIGN KEY (surgeryId) REFERENCES Surgery(surgeryId)
);

-- Create Bill Table
CREATE TABLE Bill (
    billId INT PRIMARY KEY,
    amount DECIMAL(10,2),
    status VARCHAR(20),  -- e.g., 'Paid', 'Unpaid'
    patientId INT,
    FOREIGN KEY (patientId) REFERENCES Patient(patientId)
);

-----------------------------------------------------------
-- Inserting Dummy Data

-- Insert Dentists
INSERT INTO Dentist VALUES 
(101, 'Alice', 'Brown', '555-1010', 'alice.brown@ads.com', 'Orthodontics'),
(102, 'Bob', 'Smith', '555-1020', 'bob.smith@ads.com', 'Endodontics'),
(103, 'Carol', 'Jones', '555-1030', 'carol.jones@ads.com', 'Periodontics');

-- Insert Patients
INSERT INTO Patient VALUES
(201, 'David', 'Lee', '555-2010', 'david.lee@example.com', '123 Main St', '1985-04-15', FALSE),
(202, 'Eva', 'Green', '555-2020', 'eva.green@example.com', '456 Oak Ave', '1990-07-20', TRUE),
(203, 'Frank', 'White', '555-2030', 'frank.white@example.com', '789 Pine Rd', '1978-11-05', FALSE);

-- Insert Surgeries
INSERT INTO Surgery VALUES
(301, 'Downtown Surgery Center', '100 Center Plaza', '555-3010'),
(302, 'Uptown Surgery Clinic', '200 Uptown Blvd', '555-3020');

-- Insert Appointments
INSERT INTO Appointment VALUES
(401, '2023-11-10', '09:00:00', 'Scheduled', 101, 201, 301),
(402, '2023-11-11', '10:30:00', 'Scheduled', 102, 202, 302),
(403, '2023-11-12', '14:00:00', 'Scheduled', 101, 203, 301),
(404, '2023-11-13', '11:00:00', 'Scheduled', 103, 201, 302),
(405, '2023-11-10', '15:00:00', 'Scheduled', 102, 203, 301);

-- Insert Bills
INSERT INTO Bill VALUES
(501, 150.00, 'Paid', 201),
(502, 200.00, 'Unpaid', 202),
(503, 100.00, 'Paid', 203);

-----------------------------------------------------------
-- SQL Queries

-- Query 1:
-- Display the list of ALL Dentists registered in the system, sorted in ascending order of their lastNames.
SELECT * FROM Dentist
ORDER BY lastName ASC;

-- Query 2:
-- Display the list of ALL Appointments for a given Dentist by their dentist_Id number.
-- Include the Patient information in the result.
-- Replace '101' with the desired dentistId.
SELECT 
    a.appointmentId,
    a.appointmentDate,
    a.appointmentTime,
    a.status,
    p.patientId,
    p.firstName,
    p.lastName,
    p.phone,
    p.email
FROM Appointment a
JOIN Patient p ON a.patientId = p.patientId
WHERE a.dentistId = 101;

-- Query 3:
-- Display the list of ALL Appointments that have been scheduled at a Surgery Location.
SELECT 
    a.appointmentId,
    a.appointmentDate,
    a.appointmentTime,
    a.status,
    s.surgeryId,
    s.name AS SurgeryName,
    s.address,
    s.phone
FROM Appointment a
JOIN Surgery s ON a.surgeryId = s.surgeryId;

-- Query 4:
-- Display the list of the Appointments booked for a given Patient on a given Date.
-- Replace '201' with the desired patientId and '2023-11-10' with the desired date.
SELECT 
    appointmentId,
    appointmentDate,
    appointmentTime,
    status
FROM Appointment
WHERE patientId = 201 AND appointmentDate = '2023-11-10';
