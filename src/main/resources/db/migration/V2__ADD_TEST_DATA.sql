-- 3 members added with 'password' as password
INSERT INTO member (email, name, password, time)
    VALUES ('test1@test.com', 'test1',
        '$2a$10$HSSCW4bgjWsx4efaeE9GvOp2ONdeNd89ilecx2OP.mS35QjRHi6nS',
        '2023-10-01 17:36:49.477397'),
    ('test2@test.com', 'test2',
        '$2a$10$HSSCW4bgjWsx4efaeE9GvOp2ONdeNd89ilecx2OP.mS35QjRHi6nS',
        '2023-10-01 17:36:49.477397'),
    ('test3@test.com', 'test3',
        '$2a$10$HSSCW4bgjWsx4efaeE9GvOp2ONdeNd89ilecx2OP.mS35QjRHi6nS',
        '2023-10-01 17:36:49.477397');

INSERT INTO quote (created, modified, member_id, content)
    VALUES
    ('2023-10-11 15:13:25', '2023-10-10 11:18:23',
        1, 'Quote #1 of user test1'),
    ('2023-10-09 22:18:09', '2023-10-09 21:15:12',
        1, 'Quote #2 of user test1'),
    ('2023-10-18 19:21:13', '2023-10-15 16:43:57',
        1, 'Quote #3 of user test1'),
    ('2023-10-11 13:57', '2023-10-07 04:29:21',
        1, 'Quote #4 of user test1'),
    ('2023-10-05 09:17:17', '2023-10-18 08:36:52',
        1, 'Quote #5 of user test1'),
    ('2023-10-12 09:10:21', '2023-10-12 04:51:25',
        2, 'Quote #1 of user test2'),
    ('2023-10-14 03:10:23', '2023-10-12 12:39:17',
        2, 'Quote #2 of user test2'),
    ('2023-10-10 01:16:13', '2023-10-08 07:26:21',
        2, 'Quote #3 of user test2'),
    ('2023-10-05 22:59:13', '2023-10-17 17:59:47',
        2, 'Quote #4 of user test2'),
    ('2023-10-12 10:38:20', '2023-10-08 07:20:32',
        2, 'Quote #5 of user test2'),
    ('2023-10-18 20:07:11', '2023-10-13 18:50:29',
        3, 'Quote #1 of user test3'),
    ('2023-10-03 16:19:24', '2023-10-12 07:26:49',
        3, 'Quote #2 of user test3'),
    ('2023-10-14 09:06:55', '2023-10-01 08:31',
        3, 'Quote #3 of user test3'),
    ('2023-10-12 15:04:06', '2023-10-06 10:20:53',
        3, 'Quote #4 of user test3'),
    ('2023-10-14 15:44:52', '2023-10-08 16:01:28',
        3, 'Quote #5 of user test3');

INSERT INTO vote (time, evaluation, owner_id, quote_id)
    VALUES
    ('2023-10-23 17:36:49.477397', 'POSITIVE', 1, 1),
    ('2023-10-19 17:36:49.477397', 'POSITIVE', 1, 1),
    ('2023-10-30 17:36:49.477397', 'POSITIVE', 1, 1),
    ('2023-11-02 17:36:49.477397', 'POSITIVE', 1, 1),
    ('2023-11-02 17:36:49.477397', 'POSITIVE', 2, 1),
    ('2023-11-07 17:36:49.477397', 'POSITIVE', 2, 1),
    ('2023-11-11 17:36:49.477397', 'POSITIVE', 2, 1),
    ('2023-11-18 17:36:49.477397', 'POSITIVE', 2, 1),
    ('2023-10-28 17:36:49.477397', 'POSITIVE', 3, 1),
    ('2023-11-01 17:36:49.477397', 'POSITIVE', 3, 1),
    ('2023-11-07 17:36:49.477397', 'POSITIVE', 3, 1),
    ('2023-11-09 17:36:49.477397', 'POSITIVE', 3, 1),
    ('2023-10-22 17:36:49.477397', 'POSITIVE', 1, 2),
    ('2023-10-23 17:36:49.477397', 'POSITIVE', 1, 2),
    ('2023-10-29 17:36:49.477397', 'POSITIVE', 1, 2),
    ('2023-11-01 17:36:49.477397', 'POSITIVE', 1, 2),
    ('2023-11-07 17:36:49.477397', 'POSITIVE', 2, 2),
    ('2023-11-12 17:36:49.477397', 'POSITIVE', 2, 2),
    ('2023-11-25 17:36:49.477397', 'POSITIVE', 2, 2),
    ('2023-11-26 17:36:49.477397', 'POSITIVE', 2, 2),
    ('2023-10-20 17:36:49.477397', 'POSITIVE', 3, 2),
    ('2023-11-03 17:36:49.477397', 'POSITIVE', 3, 2),
    ('2023-11-04 17:36:49.477397', 'POSITIVE', 3, 2),
    ('2023-10-24 17:36:49.477397', 'POSITIVE', 1, 3),
    ('2023-11-05 17:36:49.477397', 'POSITIVE', 1, 3),
    ('2023-11-09 17:36:49.477397', 'POSITIVE', 1, 3),
    ('2023-11-17 17:36:49.477397', 'POSITIVE', 1, 3),
    ('2023-10-23 17:36:49.477397', 'POSITIVE', 2, 3),
    ('2023-10-31 17:36:49.477397', 'POSITIVE', 2, 3),
    ('2023-11-06 17:36:49.477397', 'POSITIVE', 2, 3),
    ('2023-11-10 17:36:49.477397', 'POSITIVE', 3, 3),
    ('2023-11-12 17:36:49.477397', 'POSITIVE', 3, 3),
    ('2023-11-14 17:36:49.477397', 'POSITIVE', 3, 3),
    ('2023-11-19 17:36:49.477397', 'POSITIVE', 1, 4),
    ('2023-11-01 17:36:49.477397', 'POSITIVE', 1, 4),
    ('2023-11-03 17:36:49.477397', 'POSITIVE', 1, 4),
    ('2023-11-04 17:36:49.477397', 'POSITIVE', 1, 4),
    ('2023-11-04 17:36:49.477397', 'POSITIVE', 2, 4),
    ('2023-11-05 17:36:49.477397', 'POSITIVE', 2, 4),
    ('2023-11-08 17:36:49.477397', 'POSITIVE', 2, 4),
    ('2023-11-04 17:36:49.477397', 'POSITIVE', 3, 4),
    ('2023-11-05 17:36:49.477397', 'POSITIVE', 3, 4),
    ('2023-10-22 17:36:49.477397', 'POSITIVE', 3, 5),
    ('2023-11-03 17:36:49.477397', 'POSITIVE', 1, 5),
    ('2023-11-05 17:36:49.477397', 'POSITIVE', 1, 5),
    ('2023-11-12 17:36:49.477397', 'POSITIVE', 1, 5),
    ('2023-11-13 17:36:49.477397', 'POSITIVE', 1, 5),
    ('2023-11-13 17:36:49.477397', 'POSITIVE', 2, 5),
    ('2023-11-14 17:36:49.477397', 'POSITIVE', 2, 5),
    ('2023-11-15 17:36:49.477397', 'POSITIVE', 3, 5),
    ('2023-11-22 17:36:49.477397', 'POSITIVE', 3, 5),
    ('2023-10-21 17:36:49.477397', 'POSITIVE', 1, 6),
    ('2023-10-22 17:36:49.477397', 'POSITIVE', 1, 6),
    ('2023-10-23 17:36:49.477397', 'POSITIVE', 1, 6),
    ('2023-10-24 17:36:49.477397', 'POSITIVE', 2, 6),
    ('2023-10-25 17:36:49.477397', 'POSITIVE', 2, 6),
    ('2023-10-26 17:36:49.477397', 'POSITIVE', 3, 6),
    ('2023-10-27 17:36:49.477397', 'POSITIVE', 3, 6),
    ('2023-11-25 00:20:32', 'POSITIVE', 1, 7),
    ('2023-11-27 09:28:40', 'POSITIVE', 1, 7),
    ('2023-11-14 09:23:44', 'POSITIVE', 1, 7),
    ('2023-11-06 21:34:32', 'POSITIVE', 2, 7),
    ('2023-11-19 02:08:03', 'POSITIVE', 2, 7),
    ('2023-11-08 10:50:10', 'POSITIVE', 2, 7),
    ('2023-11-27 01:02:54', 'POSITIVE', 3, 7),
    ('2023-11-02 02:29:33', 'POSITIVE', 1, 8),
    ('2023-11-14 04:54:49', 'POSITIVE', 1, 8),
    ('2023-11-29 05:56:49', 'POSITIVE', 2, 8),
    ('2023-11-26 01:06:30', 'POSITIVE', 2, 8),
    ('2023-12-01 03:44:19', 'POSITIVE', 2, 8),
    ('2023-11-26 03:40:57', 'POSITIVE', 2, 8),
    ('2023-11-02 15:13:01', 'POSITIVE', 3, 8),
    ('2023-11-10 12:10:38', 'POSITIVE', 1, 9),
    ('2023-11-19 08:37:47', 'POSITIVE', 1, 9),
    ('2023-11-03 13:54:52', 'POSITIVE', 1, 9),
    ('2023-11-07 20:41:28', 'POSITIVE', 2, 9),
    ('2023-11-27 09:43:20', 'POSITIVE', 2, 9),
    ('2023-11-22 17:26:57', 'POSITIVE', 2, 9),
    ('2023-11-23 05:53:50', 'POSITIVE', 2, 9),
    ('2023-11-24 02:27:27', 'POSITIVE', 1, 10),
    ('2023-11-13 22:40:10', 'POSITIVE', 2, 10),
    ('2023-11-29 13:30:34', 'POSITIVE', 2, 10),
    ('2023-11-18 12:09:24', 'POSITIVE', 2, 10),
    ('2023-11-03 07:33:55', 'POSITIVE', 2, 10),
    ('2023-11-25 22:01:40', 'POSITIVE', 3, 10),
    ('2023-11-04 04:01:04', 'POSITIVE', 1, 11),
    ('2023-11-03 07:33:55', 'POSITIVE', 2, 11),
    ('2023-11-29 17:27:24', 'POSITIVE', 2, 11),
    ('2023-11-20 23:58:12', 'POSITIVE', 1, 12),
    ('2023-11-21 15:34:20', 'POSITIVE', 1, 13),
    ('2023-11-15 00:02:10', 'POSITIVE', 2, 14),
    ('2023-11-09 10:33:36', 'POSITIVE', 2, 14),
    ('2023-11-03 22:31:30', 'NEGATIVE', 1, 15),
    ('2023-11-13 11:54:16', 'NEGATIVE', 1, 15),
    ('2023-11-29 16:04:20', 'NEGATIVE', 1, 15),
    ('2023-11-23 02:15:14', 'NEGATIVE', 1, 15),
    ('2023-11-23 13:26:56', 'NEGATIVE', 2, 15),
    ('2023-11-04 10:54:41', 'NEGATIVE', 2, 15),
    ('2023-11-17 13:57:59', 'NEGATIVE', 2, 15),
    ('2023-11-28 00:51:32', 'NEGATIVE', 2, 15),
    ('2023-11-10 11:20:08', 'NEGATIVE', 2, 15),
    ('2023-11-22 18:09:56', 'NEGATIVE', 2, 15),
    ('2023-11-08 11:26:56', 'NEGATIVE', 3, 15),
    ('2023-11-10 06:27:12', 'NEGATIVE', 3, 15),
    ('2023-11-15 01:47:03', 'NEGATIVE', 3, 15),
    ('2023-11-20 11:18:58', 'NEGATIVE', 3, 15),
    ('2023-11-15 02:20:56', 'NEGATIVE', 1, 14),
    ('2023-11-06 23:28:26', 'NEGATIVE', 1, 14),
    ('2023-11-28 14:53:39', 'NEGATIVE', 1, 14),
    ('2023-11-12 08:39:42', 'NEGATIVE', 1, 14),
    ('2023-11-11 17:51', 'NEGATIVE', 1, 14),
    ('2023-11-10 02:33:09', 'NEGATIVE', 2, 14),
    ('2023-11-10 01:22:47', 'NEGATIVE', 2, 14),
    ('2023-11-19 01:58:29', 'NEGATIVE', 2, 14),
    ('2023-11-11 19:16:22', 'NEGATIVE', 2, 14),
    ('2023-11-21 21:30:59', 'NEGATIVE', 3, 14),
    ('2023-11-01 17:49:48', 'NEGATIVE', 3, 14),
    ('2023-11-02 02:25:33', 'NEGATIVE', 3, 14),
    ('2023-11-15 15:41:57', 'NEGATIVE', 1, 13),
    ('2023-11-18 05:51:33', 'NEGATIVE', 1, 13),
    ('2023-11-09 11:58:14', 'NEGATIVE', 1, 13),
    ('2023-11-20 18:26:12', 'NEGATIVE', 1, 13),
    ('2023-11-04 07:29:54', 'NEGATIVE', 2, 13),
    ('2023-11-16 22:48:07', 'NEGATIVE', 2, 13),
    ('2023-11-24 08:54:46', 'NEGATIVE', 2, 13),
    ('2023-11-20 00:22:50', 'NEGATIVE', 2, 13),
    ('2023-11-28 10:15:23', 'NEGATIVE', 3, 13),
    ('2023-11-08 08:47:29', 'NEGATIVE', 3, 13),
    ('2023-11-27 14:19:07', 'NEGATIVE', 1, 12),
    ('2023-11-11 20:23:57', 'NEGATIVE', 1, 12),
    ('2023-11-18 21:45:52', 'NEGATIVE', 1, 12),
    ('2023-11-07 11:35:10', 'NEGATIVE', 1, 12),
    ('2023-11-09 14:04:23', 'NEGATIVE', 2, 12),
    ('2023-11-29 02:59:26', 'NEGATIVE', 2, 12),
    ('2023-11-22 23:50:16', 'NEGATIVE', 2, 12),
    ('2023-11-06 00:12:54', 'NEGATIVE', 2, 12),
    ('2023-11-21 15:27:31', 'NEGATIVE', 3, 12),
    ('2023-11-03 15:09:18', 'NEGATIVE', 1, 11),
    ('2023-11-18 01:08:08', 'NEGATIVE', 1, 11),
    ('2023-11-13 18:05:04', 'NEGATIVE', 1, 11),
    ('2023-11-07 15:19:13', 'NEGATIVE', 1, 11),
    ('2023-11-28 00:17:33', 'NEGATIVE', 2, 11),
    ('2023-11-28 20:56:11', 'NEGATIVE', 2, 11),
    ('2023-11-10 00:42:23', 'NEGATIVE', 2, 11),
    ('2023-11-12 13:36:30', 'NEGATIVE', 2, 11),
    ('2023-11-05 14:01:42', 'NEGATIVE', 1, 10),
    ('2023-11-27 23:26:29', 'NEGATIVE', 1, 10),
    ('2023-11-02 21:11:17', 'NEGATIVE', 1, 10),
    ('2023-11-20 02:09:08', 'NEGATIVE', 1, 10),
    ('2023-11-10 17:32:08', 'NEGATIVE', 3, 10),
    ('2023-11-08 23:38:19', 'NEGATIVE', 3, 10),
    ('2023-11-25 05:32:36', 'NEGATIVE', 3, 10),
    ('2023-11-19 07:47:03', 'NEGATIVE', 3, 10),
    ('2023-11-06 20:00:18', 'NEGATIVE', 1, 9),
    ('2023-11-29 23:21:24', 'NEGATIVE', 1, 9),
    ('2023-11-15 06:32:57', 'NEGATIVE', 1, 9),
    ('2023-11-29 20:25:31', 'NEGATIVE', 1, 9),
    ('2023-11-21 04:55:20', 'NEGATIVE', 3, 9),
    ('2023-11-06 21:15:50', 'NEGATIVE', 3, 9),
    ('2023-11-07 03:03:16', 'NEGATIVE', 3, 9),
    ('2023-11-25 01:18:01', 'NEGATIVE', 1, 8),
    ('2023-11-28 08:48:46', 'NEGATIVE', 1, 8),
    ('2023-11-19 13:36:24', 'NEGATIVE', 1, 8),
    ('2023-11-30 00:54:53', 'NEGATIVE', 1, 8),
    ('2023-11-22 20:13:54', 'NEGATIVE', 3, 8),
    ('2023-11-22 23:49:29', 'NEGATIVE', 3, 8),
    ('2023-11-18 10:59:35', 'NEGATIVE', 1, 7),
    ('2023-11-14 02:07:28', 'NEGATIVE', 1, 7),
    ('2023-11-30 14:19:39', 'NEGATIVE', 1, 7),
    ('2023-11-26 22:10:39', 'NEGATIVE', 1, 7),
    ('2023-11-08 16:13:36', 'NEGATIVE', 3, 7),
    ('2023-11-09 19:31:39', 'NEGATIVE', 1, 6),
    ('2023-11-29 20:40:02', 'NEGATIVE', 1, 6),
    ('2023-11-23 10:23:02', 'NEGATIVE', 1, 6),
    ('2023-11-23 08:18:25', 'NEGATIVE', 1, 6),
    ('2023-11-09 21:51:14', 'NEGATIVE', 2, 5),
    ('2023-11-05 15:14:49', 'NEGATIVE', 2, 5),
    ('2023-11-19 04:58:57', 'NEGATIVE', 2, 5),
    ('2023-11-02 20:21:23', 'NEGATIVE', 3, 5),
    ('2023-11-29 22:17:18', 'NEGATIVE', 2, 4),
    ('2023-11-21 02:09:59', 'NEGATIVE', 3, 4),
    ('2023-11-22 09:55:42', 'NEGATIVE', 3, 4),
    ('2023-11-30 05:10:24', 'NEGATIVE', 2, 3),
    ('2023-11-23 17:17:46', 'NEGATIVE', 2, 3),
    ('2023-11-12 20:24:16', 'NEGATIVE', 2, 3),
    ('2023-11-29 14:03:48', 'NEGATIVE', 3, 2),
    ('2023-11-09 13:20:52', 'NEGATIVE', 3, 2);