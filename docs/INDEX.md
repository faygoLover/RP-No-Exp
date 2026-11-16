# RP No-Exp — указатель кода

Создано `python _family/tools/mapgen.py`, версия мода 1.0.0-1.20.1-forge.
**Руками не править**: пересоздаётся скриптом. Смысл, потоки работы и рецепты — в `docs/MAP.md`.
Разбор по шаблонам, без компиляции: необычно оформленная регистрация может отсутствовать в списках.

Всего: 4 файлов, 128 строк Java.

## 1. Пакеты

| Пакет | Файлов | Строк |
|---|---:|---:|
| `faygolover.rpnoexp` | 2 | 79 |
| `faygolover.rpnoexp.client` | 1 | 21 |
| `faygolover.rpnoexp.mixin` | 1 | 28 |

## 2. Классы

### `faygolover.rpnoexp`
- `NoExpConfig`, 29 — Конфиг RP No-Exp: config/rpnoexp-common.toml.
- `RpNoExp`, 50 — RP No-Exp — опыт выключен: нет сфер, опыт ни от чего не прибавляется, полоски опыта нет (client/HideBar).

### `faygolover.rpnoexp.client`
- `HideBar`, 21 — Полоска опыта с числом уровня не рисуется.

### `faygolover.rpnoexp.mixin`
- `ExperienceCommandMixin`, 28 — /xp add (и /experience add) начисляет опыт через giveExperiencePoints/giveExperienceLevels — на время вызова открываем начисление.

Классов без описания: 0 из 4.

## 3. Подписки на события

| Событие | Кто слушает |
|---|---|
| `EntityJoinLevelEvent` | `RpNoExp.onJoin` |
| `PlayerXpEvent.LevelChange` | `RpNoExp.onLevel` |
| `PlayerXpEvent.XpChange` | `RpNoExp.onXp` |
| `RenderGuiOverlayEvent.Pre` | `HideBar.onOverlay` |

## 4. Сеть

Нет.

## 5. Команды

Нет.

## 6. Данные

Нет.

## 7. Конфиги

- common: `NoExpConfig`, вызовов define 3

## 8. Что берёт из RP Core и что ему даёт

Не использует.

## 9. Связи с другими модами


Миксины (1):
- `ExperienceCommandMixin` (mixins) → ExperienceCommand.class

## 10. Зарегистрированные id

Нет или регистрируются не строковыми литералами.
