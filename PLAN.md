# Work plan: consolidate ad placement providers

Ngày bắt đầu: 2026-10-13
Ngày kết thúc: Chưa kết thúc — Auto test đang bị chặn bởi lỗi Gradle loopback.

## Tasks

- [completed] Lập plan/task: xác định API `AdSlot`, các base class và `ContextAds` cần cập nhật; giữ tương thích với provider cũ.
- [completed] Code: thêm cấu hình placement dạng một danh sách, chuyển luồng khởi tạo/reinit sang cấu hình mới và migrate caller mẫu; giữ compatibility bridge cho các caller cũ.
- [completed] Viết test: thêm unit test cho việc phân nhóm `AdSlot` và cờ preload.
- [in_progress] Auto test: chạy test hẹp của `core:baseui`, kiểm tra compile liên quan và `git diff --check`.

## Scope

- Affected features: BaseActivity, BaseFragment, BaseAdsDialogFragment, BaseAdsBottomSheetDialogFragment, ContextAds, and the main host screen; existing ad-enabled screens remain supported through the deprecated bridge.
- Behavior to preserve: banner/native preload distinction, interstitial/reward grouping, `NativeInterstitial` staying in the interstitial group, and runtime reinitialization.
- Compatibility: old provider methods remain as deprecated fallback until all callers outside this repository migrate.

## Verification

- Focused JVM test for `AdSlot` grouping.
- `./gradlew.bat :core:baseui:testDevDebugUnitTest`
- `./gradlew.bat :core:baseui:compileDevDebugKotlin`
- `git diff --check`

## Test log

- `git diff --check`: passed.
- `:core:baseui:testDevDebugUnitTest`: blocked before task execution; Gradle reports `java.io.IOException: Unable to establish loopback connection`.
- `:core:baseui:compileDevDebugKotlin`: blocked by the same environment issue after supplying Android Studio JBR manually.
- Auto test remains `in_progress` until Gradle can start successfully.
