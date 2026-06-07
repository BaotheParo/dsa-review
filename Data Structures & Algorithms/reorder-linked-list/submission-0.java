/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // BƯỚC 1: Tìm trung điểm bằng Tortoise and Hare (Rùa và Thỏ)
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // BƯỚC 2: Đảo ngược nửa sau danh sách liên kết
        ListNode head2 = slow.next;
        slow.next = null; // Cắt đứt mối liên kết giữa 2 nửa
        
        ListNode prev = null;
        ListNode curr = head2;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head2 = prev; // head2 bây giờ là đỉnh của nửa sau đã đảo ngược

        // BƯỚC 3: Trộn xen kẽ p1 (nửa đầu) và p2 (nửa sau)
        ListNode p1 = head;
        ListNode p2 = head2;
        while (p2 != null) {
            ListNode nxt1 = p1.next;
            ListNode nxt2 = p2.next;

            p1.next = p2;       // Node nửa đầu chỉ sang Node nửa sau
            p2.next = nxt1;     // Node nửa sau chỉ về Node kế tiếp của nửa đầu

            p1 = nxt1;          // Tiến p1 lên
            p2 = nxt2;          // Tiến p2 lên
        }
    }
}
